@set user = 1
@set book = 18
@set reading = 'Wanting to Read'

insert into library (user_id, book_id, reading_status)
	values(:user, :book, :reading);
