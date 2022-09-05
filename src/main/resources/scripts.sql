--user registration
insert into reg_user(number, email, name, password)
values('1111111111', 'porus@lostwar.com', 'alexander burod', '$2a$10$U5aPLm3PA5PxHQGanYFvmuIz5QC2Fc6mq5IPf65iYUbSpwQo6qKAm')

--insert contacts
insert into contact(contact_id, name, number, user_number)
values(1, 'ram', '7683746483', '1111111111'),
		(2, 'rahim', '7683746483', '1111111111'),
		(3, 'kabir', '7684646123', '1111111111'),
		(4, 'nanak', '9756746483', '1111111111'),
		(5, 'govind', '9876567895', '1111111111'),
		(6, 'meera', '7689876544', '1111111111')

--insert spam

insert into spam(spam_id, number, user_number)
values(10000, '22222222', '1111111111'),
		(20000, '9876567895', '1111111111'),
		(30000, '6565767687', '1111111111')