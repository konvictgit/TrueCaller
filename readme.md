1. Use java 17 and eclipse IDE to build and run the project
2. Use Postgres14 as database
3. Modify the application.properties file with your own database credentials
4. Replace <DATABASE_NAME>, <DATABASE_USER>, and <PASSWORD> with your own values.
5. Run the queries in scripts.sql file in the database;

6. login using the below curl
   ```shell
    curl --location --request POST 'http://localhost:8080/login' \
    --header 'Content-Type: application/x-www-form-urlencoded' \
    --data-urlencode 'username=1111111111' \
    --data-urlencode 'password=abcd'
    ```

7. Use cookie JSESSIONID in further requests otherwise you'll be asked to log in again.

8. You can register new users with the following curl
    ```shell
    curl --location --request POST 'localhost:8080/register' \
    --header 'Content-Type: application/json' \
    --header 'Cookie: JSESSIONID=1B0A027709AB6AE6BE632558F3B9BB41' \
    --data-raw '{
    "name": "Jat ball",
    "number": "2323232323",
    "password": "ball",
    "email": "jat@ball.com"
    }'
    ```
   Phone number and emailId should be unique.
