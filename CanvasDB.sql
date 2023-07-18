--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2023-07-14 11:36:21

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

--
-- TOC entry 3345 (class 1262 OID 16433)
-- Name: CanvasInstructure; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "CanvasInstructure" WITH TEMPLATE = template0 ENCODING = 'UTF8';


ALTER DATABASE "CanvasInstructure" OWNER TO postgres;

\connect "CanvasInstructure"

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
-- TOC entry 215 (class 1259 OID 16478)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    id integer NOT NULL,
    account_id integer,
    name character varying(255) NOT NULL,
    workflow_state character varying(255) NOT NULL,
    parent_account_id integer,
    root_account_id integer,
    uuid character varying(500) NOT NULL,
    default_storage_quota_mb integer NOT NULL,
    default_user_storage_quota_mb integer NOT NULL,
    default_group_storage_quota_mb integer NOT NULL,
    default_time_zone character varying(255) NOT NULL
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16477)
-- Name: account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_id_seq OWNER TO postgres;

--
-- TOC entry 3346 (class 0 OID 0)
-- Dependencies: 214
-- Name: account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.account_id_seq OWNED BY public.account.id;


--
-- TOC entry 217 (class 1259 OID 16512)
-- Name: course; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.course (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    account_id integer,
    uuid character varying(500) NOT NULL,
    start_at character varying(200),
    grading_standard_id integer,
    is_public boolean NOT NULL,
    created_at character varying(200),
    course_code character varying(255),
    default_view character varying(255),
    root_account_id integer,
    enrollment_term_id integer,
    license character varying(255),
    end_at character varying(200),
    public_syllabus boolean NOT NULL,
    public_syllabus_to_auth boolean NOT NULL,
    storage_quota_mb integer,
    is_public_to_auth_users boolean NOT NULL,
    apply_assignment_group_weights boolean NOT NULL,
    time_zone character varying(255) NOT NULL,
    blueprint boolean NOT NULL,
    sis_course_id character varying(255),
    sis_import_id character varying(255),
    integration_id character varying(255),
    hide_final_grades boolean NOT NULL,
    workflow_state character varying(255) NOT NULL,
    restrict_enrollments_to_course_dates boolean NOT NULL,
    course_id integer
);


ALTER TABLE public.course OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16511)
-- Name: course_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.course_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.course_id_seq OWNER TO postgres;

--
-- TOC entry 3347 (class 0 OID 0)
-- Dependencies: 216
-- Name: course_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.course_id_seq OWNED BY public.course.id;


--
-- TOC entry 219 (class 1259 OID 16550)
-- Name: enrollment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.enrollment (
    id integer NOT NULL,
    type character varying(100) NOT NULL,
    role_id integer,
    user_id integer,
    enrollment_state character varying(100),
    course_id integer
);


ALTER TABLE public.enrollment OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16549)
-- Name: enrollment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.enrollment_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.enrollment_id_seq OWNER TO postgres;

--
-- TOC entry 3348 (class 0 OID 0)
-- Dependencies: 218
-- Name: enrollment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.enrollment_id_seq OWNED BY public.enrollment.id;


--
-- TOC entry 3183 (class 2604 OID 16481)
-- Name: account id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account ALTER COLUMN id SET DEFAULT nextval('public.account_id_seq'::regclass);


--
-- TOC entry 3184 (class 2604 OID 16515)
-- Name: course id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course ALTER COLUMN id SET DEFAULT nextval('public.course_id_seq'::regclass);


--
-- TOC entry 3185 (class 2604 OID 16553)
-- Name: enrollment id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollment ALTER COLUMN id SET DEFAULT nextval('public.enrollment_id_seq'::regclass);


--
-- TOC entry 3187 (class 2606 OID 16496)
-- Name: account account_account_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_account_id_key UNIQUE (account_id);


--
-- TOC entry 3189 (class 2606 OID 16485)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- TOC entry 3191 (class 2606 OID 16519)
-- Name: course course_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_pkey PRIMARY KEY (id);


--
-- TOC entry 3195 (class 2606 OID 16555)
-- Name: enrollment enrollment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollment
    ADD CONSTRAINT enrollment_pkey PRIMARY KEY (id);


--
-- TOC entry 3193 (class 2606 OID 16548)
-- Name: course unique_course_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT unique_course_id UNIQUE (course_id);


--
-- TOC entry 3196 (class 2606 OID 16520)
-- Name: course course_account_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.course
    ADD CONSTRAINT course_account_id_fkey FOREIGN KEY (account_id) REFERENCES public.account(account_id);


--
-- TOC entry 3197 (class 2606 OID 16556)
-- Name: enrollment enrollment_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.enrollment
    ADD CONSTRAINT enrollment_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.course(course_id);


-- Completed on 2023-07-14 11:36:22

--
-- PostgreSQL database dump complete
--

