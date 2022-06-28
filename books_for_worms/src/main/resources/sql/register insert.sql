
@set username = 'janedoe'
@set pass = 'pass4321'
@set email = 'janedoe@gmail.com'


INSERT INTO users (user_name, password,  email)
values (:username, :pass, :email);