#!C:\cygwin64\bin\bash.exe
chcp 65001
java -Dcgi.request_method=$REQUEST_METHOD -Dcgi.query_string=$QUERY_STRING -jar home.jar $HTTP_COOKIE