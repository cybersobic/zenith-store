--
-- PostgreSQL database dump
--

-- Dumped from database version 16.6 (Ubuntu 16.6-0ubuntu0.24.04.1)
-- Dumped by pg_dump version 16.6 (Ubuntu 16.6-0ubuntu0.24.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    id bigint NOT NULL,
    name character varying(30) NOT NULL,
    image_link character varying(70)
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.categories_id_seq OWNER TO postgres;

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.categories.id;


--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    category_id integer NOT NULL,
    price integer NOT NULL,
    description character varying(700),
    image_link character varying(70)
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.products_id_seq OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    login character varying(24) NOT NULL,
    password character varying(64) NOT NULL,
    phone_number character varying(15) NOT NULL,
    email character varying(320) NOT NULL,
    first_name character varying(35),
    last_name character varying(35),
    company character varying(50)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categories (id, name, image_link) FROM stdin;
1	Программное обеспечение	images/category_images/programs.png
2	Надстройки	images/category_images/addons.png
3	Модули	images/category_images/modules.png
4	Интеграции	images/category_images/integrations.png
5	Комплексы	images/category_images/complexes.png
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (id, name, category_id, price, description, image_link) FROM stdin;
2	Надстройка «Клонирование операций»	2	7500	Надстройка предназначена для ввода в оперативный план дополнительных позиций (деталей, партий деталей или узлов) и операций, позволяющих поддержать процессы, возникающие в ходе изготовления изделия, такие как изготовление части заказа по отдельному графику или устранение брака.	images/product_images/addon.png
3	Надстройка «Периодические простои»	2	9000	Надстройка применяется для быстрого ввода организационных простоев в случаях, когда необходимо установить специальный график работы для одного или нескольких рабочих мест. Надстройка интегрируется с основным программным модулем автоматизированной системы Zenith SPPS. Работа с надстройкой начинается с создания новой серии простоев, для чего необходимо нажать кнопку «Создать новую серию». После этого серия появится в плане простоев.	images/product_images/addon.png
4	Надстройка «Планируемое время»	2	4000	Надстройку «Планируемое время» целесообразно использовать, когда в оперативном плане Zenith SPPS требуется ввести значения времени «Запуск» и «Выпуск» сразу для всех позиций заказа или изделия. После запуска надстройки на экране появится диалоговое окно, в котором будет отражено название текущей позиции оперативного плана, а также минимальное время запуска и требуемое время выпуска. В верхней части диалога можно указать, вводить ли указанное время для текущей позиции, всех позиций изделия или всех позиций заказа.	images/product_images/addon.png
5	Надстройка «Вывод операций»	2	5500	Надстройка «Вывод операций» предназначена для исключения части технологических операций из производственного расписания. Исключаемые операции переводятся в разряд «новых» и затем повторно добавляются в расписание при его перерасчете или коррекции. В отличие от стандартной функции «Пометить как новые…», надстройка обеспечивает вывод операций применительно к определенным частям расписания в целом, а не к отдельным заказам, позициям оперативного плана или операциям.	images/product_images/addon.png
6	Надстройка «Расчёт трудоёмкости операций»	2	4500	В ряде случаев на производстве необходим упрощенный расчет объемов операций, исходя из количества позиций оперативного плана, к которым эти операции относятся. Применение упрощенного расчета объемов операций при помощи надстройки «Расчёт трудоёмкости операций» может быть обоснованным, когда объём всех операций, необходимых для изготовления позиции (например, партии деталей) одинаков, и это справедливо для большинства позиций, входящих в ряд заказов.	images/product_images/addon.png
7	Надстройка «Разбиение заказа на партии»	2	2000	Надстройка «Разбиение заказа на партии» (в дальнейшем – надстройка) предназначена для разбиения партий деталей, входящих в заказ, на более мелкие партии. При этом происходит пропорциональное уменьшение объемов операций заказа в нормативных единицах.	images/product_images/addon.png
8	Надстройка «Импорт данных»	2	6000	Надстройка «Импорт данных» (в дальнейшем – надстройка) предназначена для обеспечения загрузки в Zenith SPPS информации о производственных заказах из текстовых файлов с расширениями S1C, имеющих специальную структуру. Файлы такой структуры могут быть сгенерированы другими информационными системами и приложениями, хранящими сведения о заказах (например, модулями технологической подготовки производства).	images/product_images/addon.png
1	Основное ПО Zenith SPPS	1	130000	Осуществляет управление и оптимизацию производственной деятельности, в режиме реального времени планирует, отслеживает, оптимизирует и документирует производственные процессы от начала выполнения заказа до выпуска готовой продукции.	images/product_images/program.png
9	Модуль Zenith Show	3	12500	Модуль Zenith Show – это программа для демонстрации результатов работы диспетчерского модуля MES-системы Zenith SPPS (например, на больших экранах в цехе или коммерческом отделе).	images/product_images/modul.png
10	Модуль удалённого доступа Zenith Terminal	3	8500	Zenith Terminal устанавливается непосредственно в цехе, например, на рабочем месте мастера. Позволяет передавать основному модулю Zenith SPPS информацию о том, что операция начата, закончена или прервана, а также просматривать сведения о текущей и нескольких последующих операциях, выполняемых на одном или нескольких рабочих местах. Переданные данные вносятся в производственное расписание и отражаются на графике загрузки рабочих мест.	images/product_images/modul.png
11	Модуль технологической подготовки Zenith TECH	3	11000	Zenith TECH – это модуль технологической подготовки, который обеспечивает удобный интерфейс для выполнения следующих действий: разузлование производственных заказов; ввод состава и объема материальных ресурсов, необходимых для выполнения заказа; ввод технологических операций; создание заказа "по шаблону"; ведение архива заказов.	images/product_images/modul.png
12	Интеграция Zenith SPPS с ПО 1С	4	15000	Широкое распространение программных продуктов 1С на российских предприятиях послужило основой для создания надстройки, позволяющей осуществлять передачу данных между ПО 1С и MES-системой Zenith SPPS. Надстройка обеспечивает загрузку в Zenith SPPS информации о производственных заказах из текстовых файлов, имеющих специальную структуру. Данные файлы могут быть легко сгенерированы средствами 1С.	images/product_images/integration_1c.png
13	Комплекс «Zenith SPPS – ТехноПро»	5	14000	Создано программное решение, интегрирующее MES-систему Zenith SPPS и систему технологической подготовки «ТехноПро». Комплекс «Zenith SPPS – ТехноПро» включает в себя систему оперативно-календарного цехового планирования (MES) и систему технологического проектирования и подготовки производства (АСТПП).	images/product_images/complex.png
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, login, password, phone_number, email, first_name, last_name, company) FROM stdin;
\.


--
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_id_seq', 5, true);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_seq', 13, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 2, true);


--
-- Name: categories categories_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_name_key UNIQUE (name);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: products products_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_name_key UNIQUE (name);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: users users_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_email_key UNIQUE (email);


--
-- Name: users users_login_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_login_key UNIQUE (login);


--
-- Name: users users_phone_number_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_phone_number_key UNIQUE (phone_number);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: products fk_products_categories; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT fk_products_categories FOREIGN KEY (category_id) REFERENCES public.categories(id);


--
-- PostgreSQL database dump complete
--

