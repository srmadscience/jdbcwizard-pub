# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this is

`com.orindasoft.pub` is a Java runtime support library for **JDBCWizard / OrindaBuild**, a product that generated Java code to invoke Oracle and DB2 PL/SQL procedures regardless of how complex their parameter interfaces were. This library is the runtime that the *generated* code depends on — end users normally never call these classes directly. The product is no longer actively developed; this repo is the published source archive (see `LICENSE`, BSD-style, owner David Rolfe).

## Repository layout — read this first

There is **no single source tree**. Each top-level numbered/named directory is a *complete parallel copy* of the same ~36-class library, tailored to one Oracle/DB2 version:

- `815` `816` `817` `901` `920` `1010` `1020` `1110` `1120` `1210` — Oracle versions (8.1.5 … 12.1)
- `db2101` `db2974` `db2demo` — DB2 builds (no `TextLog.java` at the top level)
- `DEMO` — demo build

The real code lives in `<version>/com/orindasoft/pub/`. **`1210` (Oracle 12.1) is the canonical / newest version** — start there. `README.md` points to `1210/com/orindasoft/pub/ReadOnlyRowSet.java` as the best entry point.

Differences between versions are small and driver-behavior-driven (e.g. `1210` adds `SqlUtils.ORACLE_SDO_GEOMETRY_DATATYPE` / `ORACLE_XMLTYPE_DATATYPE` cases that older drivers reported as `OTHER`). `LibraryInfo.getLibraryVersion()` returns the directory name (`"1210"`, etc.).

**When fixing a bug or adding a feature, the change usually must be applied to every version directory**, not just one. Use `diff <ver1>/com/orindasoft/pub/<File>.java <ver2>/...` to see how a class already varies across versions before editing, and respect existing per-version divergences.

## Building

There is no in-repo build system (no Maven/Gradle/Ant). Each version directory ships Eclipse (`.classpath`, `.project`) and Oracle JDeveloper (`.jpr`, `.jws`) project files. The `.classpath` files reference **Windows-absolute jar paths** (e.g. `C:/DR/Work/CodeSpooks/Lib/...`) that will not exist locally.

To compile a version you must supply the external dependencies on the classpath:
- An Oracle JDBC driver matching the version (`ojdbcN.jar`) — provides `oracle.jdbc.*`, `oracle.sql.ARRAY`/`ArrayDescriptor`, `OracleTypes`.
- `log4j-1.2.x`, `j2ee.jar` (JDBC `RowSet`/`javax.sql`), and JNDI helpers per the `.classpath`.
- JDK with Swing (`javax.swing.*` is used by `UiLog`).

Example compile of the canonical version:
```sh
javac -cp "ojdbc.jar:j2ee.jar:log4j-1.2.8.jar" -d /tmp/out 1210/com/orindasoft/pub/*.java
```
There is no test suite in this repo; regression-test examples live in the separate `jdbcwizard-test-code` project.

## Architecture

The library has three loosely-coupled concern areas, all under the single package `com.orindasoft.pub`.

**1. PL/SQL statement invocation (the core).**
`StatementParameters2` is the base class holding a parameter map and binding logic. The hierarchy is:
`StatementParameters2` → `CallableStatementParameters` (for `CallableStatement`/PL/SQL calls), and `StatementParameters2` → `DmlStatement` (abstract) → `QueryStatement` (adds query result caching). `DmlStatement` and `QueryStatement` implement `OracleResourceUser`.

**2. Result handling / type marshalling.**
`ReadOnlyRowSet` (and its subclass `WriteableRowSet`) wrap result data with strongly-typed, exception-rich accessors. `SqlUtils` centralizes datatype constants and conversion logic (this is where version-specific Oracle type handling lives). `PlsqlArray`, `PlsqlIndexByTable`/`PlsqlIndexByTable2`, and `JavaArrayObject` model PL/SQL collection / array types. `LongObjectLoader` and `IOUtils` handle LONG/stream data.

**3. Logging and resource management.**
`LogInterface` defines a 5-level logging contract (debug/info/warning/error/syserror) that customers can implement to integrate with their own app. `GenericLog` is the abstract base; concrete impls are `ConsoleLog`, `TextLog`, and `UiLog` (Swing dialogs, extends `TextLog`). `StatsInterface` is for stats hooks. `OracleResourceUser` is the interface for any object holding cursors/statements — implementers expose `hasResources()`/`releaseResources()` so a manager (`ResourceWatcher`) can iterate and free Oracle resources deterministically.

**Exceptions.** All custom exceptions extend `CSException extends Exception` (e.g. `CSDBException`, `CSColumnException`, `CSInvalidDataTypeException`, `CSAttemptToGetNullException`). `CSDBNullObjectException` extends `CSDBException`. These give the generated code precise, catchable failure types instead of raw `SQLException`.

## Documentation

`docs/` is generated Javadoc (published at https://srmadscience.github.io/jdbcwizard-pub/) for Oracle 12.1 — it is build output, not hand-maintained source. Related repos referenced in `README.md`: `jdbcwizard-dbhell` (schema generation), `jdbcwizard-demo-code`, `jdbcwizard-test-code`.
