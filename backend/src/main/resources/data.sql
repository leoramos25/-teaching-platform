INSERT INTO tb_user (name, email, password) VALUES ('Alex Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Maria Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_STUDENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_INSTRUCTOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 3);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 3);

INSERT INTO tb_course (name, img_uri, img_gray_uri) VALUES ('Bootcamp HTML', 'https://www.publicdomainpictures.net/pictures/390000/nahled/course-introduction.jpg', 'https://www.publicdomainpictures.net/pictures/360000/nahled/online-learning.jpg');

INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('1.0', TIMESTAMP WITH TIME ZONE '2022-05-16T12:00:00Z', TIMESTAMP WITH TIME ZONE '2022-05-21T02:59:59Z',1);
INSERT INTO tb_offer (edition, start_moment, end_moment, course_id) VALUES ('2.0', TIMESTAMP WITH TIME ZONE '2022-08-22T12:00:00Z', TIMESTAMP WITH TIME ZONE '2022-08-26T02:59:59Z',1);

INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Trilha HTML', 'Trilha principal do curso', 1, 'https://www.publicdomainpictures.net/pictures/390000/nahled/course-introduction.jpg', 1, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Forum', 'Tire suas dúvidas', 2, 'https://www.publicdomainpictures.net/pictures/390000/nahled/course-introduction.jpg', 2, 1);
INSERT INTO tb_resource (title, description, position, img_uri, type, offer_id) VALUES ('Lives', 'Lives exclusivas para a turma', 3, 'https://www.publicdomainpictures.net/pictures/390000/nahled/course-introduction.jpg', 0, 1);

INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id) VALUES ('Chapter 1', 'Neste capítulo vamos iniciar o projeto do bootcamp', 1, 'https://www.publicdomainpictures.net/pictures/390000/nahled/course-introduction.jpg', 1, null);
INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id) VALUES ('Chapter 2', 'Neste capítulo vamos continuar o projeto do bootcamp', 1, 'https://www.publicdomainpictures.net/pictures/390000/nahled/course-introduction.jpg', 1, 1);
INSERT INTO tb_section (title, description, position, img_uri, resource_id, prerequisite_id) VALUES ('Chapter 3', 'Neste capítulo vamos finalizar o projeto do bootcamp', 1, 'https://www.publicdomainpictures.net/pictures/390000/nahled/course-introduction.jpg', 1, 2);

INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (1, 1, TIMESTAMP WITH TIME ZONE '2022-05-16T14:00:00Z', null, true, false);
INSERT INTO tb_enrollment (user_id, offer_id, enroll_moment, refund_moment, available, only_update) VALUES (2, 1, TIMESTAMP WITH TIME ZONE '2022-05-16T18:00:00Z', null, true, false);

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 1', 1, 1);
INSERT INTO tb_content (id, text_content, video_uri) VALUES (1, 'Material de apoio', 'https://www.youtube.com/watch?v=wzJTpzHHoVg');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 2', 2, 1);
INSERT INTO tb_content (id, text_content, video_uri) VALUES (2, '', 'https://www.youtube.com/watch?v=wzJTpzHHoVg');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Aula 3', 3, 1);
INSERT INTO tb_content (id, text_content, video_uri) VALUES (3, '', 'https://www.youtube.com/watch?v=wzJTpzHHoVg');

INSERT INTO tb_lesson (title, position, section_id) VALUES ('Tarefa do capítulo 1', 4, 1);
INSERT INTO tb_task (id, description, question_count, approval_count, weight, due_date) VALUES (4, 'Fazer um CRUD', 5, 4, 1.0, TIMESTAMP WITH TIME ZONE '2022-05-25T18:00:00Z');

INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (1, 1, 1);
INSERT INTO tb_lessons_done (lesson_id, user_id, offer_id) VALUES (2, 1, 1);

INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Primeiro feedback da tarefa: Favor revisar', TIMESTAMP WITH TIME ZONE '2022-05-30T18:00:00Z', false, '/offer/test', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Segundo feedback da tarefa: Favor revisar', TIMESTAMP WITH TIME ZONE '2022-06-06T18:00:00Z', true, '/offer/test/1', 1);
INSERT INTO tb_notification (text, moment, read, route, user_id) VALUES ('Terceiro feedback da tarefa: Muito bom, parabéns', TIMESTAMP WITH TIME ZONE '2022-06-07T18:00:00Z', false, '/offer/test/1', 1);

INSERT INTO tb_deliver (uri, moment, status, feedback, correct_count, lesson_id, user_id, offer_id) VALUES ('https://www.github.com/devsuperior/bds-dslearn', TIMESTAMP WITH TIME ZONE '2022-06-07T18:00:00Z', 0, null, null, 4, 1, 1);

INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 1', 'Corpo do tópico 1', TIMESTAMP WITH TIME ZONE '2022-05-28T13:00:00Z', 1, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 2', 'Corpo do tópico 2', TIMESTAMP WITH TIME ZONE '2022-05-22T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 3', 'Corpo do tópico 3', TIMESTAMP WITH TIME ZONE '2022-05-24T13:00:00Z', 2, 1, 1);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 4', 'Corpo do tópico 4', TIMESTAMP WITH TIME ZONE '2022-05-16T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 5', 'Corpo do tópico 5', TIMESTAMP WITH TIME ZONE '2022-05-27T13:00:00Z', 1, 1, 2);
INSERT INTO tb_topic (title, body, moment, author_id, offer_id, lesson_id) VALUES ('Título do tópico 6', 'Corpo do tópico 6', TIMESTAMP WITH TIME ZONE '2022-05-30T13:00:00Z', 2, 1, 3);

INSERT INTO tb_topic_likes (topic_id, user_id) VALUES (1, 2);
INSERT INTO tb_topic_likes (topic_id, user_id) VALUES (2, 1);

INSERT INTO tb_reply (body, moment, topic_id, author_id) VALUES ('Tente reiniciar o computador', TIMESTAMP WITH TIME ZONE '2022-05-30T13:00:00Z', 1, 2);
INSERT INTO tb_reply (body, moment, topic_id, author_id) VALUES ('Deu certo, valeu!', TIMESTAMP WITH TIME ZONE '2022-05-30T13:00:00Z', 1, 1);

INSERT INTO tb_reply_likes (reply_id, user_id) VALUES (1, 1);

