# jdbcwizard-pub
Public utility library for JDBCWizard. This code contains useful functionality for working with Oracle, JDBC and PL/SQL

# What is this code for?

This code is com.orindasoft.pub, a utility library used by JDBCWizard, an application that generated Java code to run Oracle or DB2 PL/SQL procedures, regardless of how complicated their interface was.

# How is it organized?

* Each directory is named after the matching Oracle or DB2 version.
* The [docs directory](https://srmadscience.github.io/jdbcwizard-pub/) contains javadoc pages for Oracle 12.1, which was the last version I worked on. As a rule new features were added over time. But there are cases where driver behavior changed between versions. A good starting point is [ReadOnlyRowSet](https://github.com/srmadscience/jdbcwizard-pub/blob/main/1210/com/orindasoft/pub/ReadOnlyRowSet.java)

# Can I use it?

Yes. 

