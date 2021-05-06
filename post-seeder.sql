use springblog_db;

truncate post_images;
truncate posts;
truncate post_details;

insert into post_details (history_of_post, is_awesome, topic_description) values
('Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.', true, 'Cat, european wild'),
('In est risus, auctor sed, tristique in, tempus sit amet, sem.', true, 'Asian water buffalo'),
('Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.', true, 'Pine siskin'),
('Quisque ut erat. Curabitur gravida nisi at nibh.', false, 'Red brocket'),
('Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', true, 'Whale, baleen'),
('Cras in purus eu magna vulputate luctus.', false, 'Lion, galapagos sea'),
('Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam. Nam tristique tortor eu pede.', true, 'Common genet'),
('Nam dui.', true, 'Burmese black mountain tortoise');

insert into post_images (image_title, url, post_id) values
('black cat', 'https://images.pexels.com/photos/37337/cat-silhouette-cats-silhouette-cat-s-eyes.jpg?cs=srgb&dl=pexels-pixabay-37337.jpg&fm=jpg', 1)

insert into posts ( title, body, post_details_id) values
('Cat Post', 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 1),
('Sharknado', 'Sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 2),
('Robot Jox', 'Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. Cras pellentesque volutpat dui.', 3),
('Everything Relative', 'Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi.', 4),
('Rosalie Goes Shopping', 'Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.', 5),
('Cut and Run (Inferno in diretta)', 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.', 6),
('Ninja, A Band of Assassins (Shinobi No Mono)', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, ped, 7e,
Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 7),
('Allegro', 'Duis bibendum. Morbi non quam nec dui luctus rutrum. Nulla tellus.', 8);




