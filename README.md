# RESTful api spring example

A simple example of RESTful application using spring 4.

## Dependencies manager
maven 3.2.5

## how to build
```bash
$ cd <project_path>
$ mvn clean package
```

## How to deploy by jetty
Copy the file springsecurityprimer.war in the jetty webapps folder.

## How to test
Go to the url http://localhost:8080/springsecurityprimer/user/mario/rossi by browser

## Credentials
user/password (USER ROLE)
admin/password (ADMIN ROLE)

### Output

```
{"firstname":"mario","lastname":"rossi"}
```
