insert into bookStore.authors (first_name, last_name) values ('Adam', 'Mickiewicz'),('Henryk','Sienikiewicz'), ('Maria','Konopnicka');
insert into publishers(name) values ('Helion'), ('Atena'), ('PWN'), ('WKiŁ');
insert into categories(name) values ('Podróże'), ('Programowanie');
insert into books(description, pages, rating, title, category_id, publisher_id) values ('Książka o programowaniu',100, 6, 'Java techniki kodowania',2,1);
insert into books_authors(book_id, author_id) values (1,1);
