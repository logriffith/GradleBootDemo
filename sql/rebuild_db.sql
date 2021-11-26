DROP TABLE IF EXISTS public.colors CASCADE;
DROP TABLE IF EXISTS public.users CASCADE;

CREATE TABLE public.colors (
	color_id serial NOT NULL,
	color_name varchar(255) NULL,
	CONSTRAINT colors_pkey PRIMARY KEY (color_id)
);

CREATE TABLE public.users (
	user_id serial NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	color_id int4 NULL,
	CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

INSERT INTO public.colors
(color_name)
VALUES('green');
INSERT INTO public.colors
(color_name)
VALUES('yellow');
INSERT INTO public.colors
(color_name)
VALUES('orange');

INSERT INTO public.users
(first_name, last_name, color_id)
VALUES('John', 'Smith', 1);
INSERT INTO public.users
(first_name, last_name, color_id)
VALUES('Jane', 'Smith', NULL);
INSERT INTO public.users
(first_name, last_name, color_id)
VALUES('Bobby', 'Smith', 3);

ALTER TABLE public.users ADD CONSTRAINT user_color_fkey FOREIGN KEY (color_id) REFERENCES colors(color_id);