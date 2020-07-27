PGDMP     7                    x            gestao_venda    9.5.22     12.3 (Ubuntu 12.3-1.pgdg20.04+1) (    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    31581    gestao_venda    DATABASE     ~   CREATE DATABASE gestao_venda WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_PT.UTF-8' LC_CTYPE = 'pt_PT.UTF-8';
    DROP DATABASE gestao_venda;
                postgres    false            �           0    0    SCHEMA public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    6            �            1259    39813    empresa    TABLE     �   CREATE TABLE public.empresa (
    id integer NOT NULL,
    nome character varying(800) NOT NULL,
    nif character varying(20) NOT NULL
);
    DROP TABLE public.empresa;
       public            postgres    false            �            1259    39811    empresa_id_seq    SEQUENCE     w   CREATE SEQUENCE public.empresa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.empresa_id_seq;
       public          postgres    false    187            �           0    0    empresa_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.empresa_id_seq OWNED BY public.empresa.id;
          public          postgres    false    186            �            1259    39786    grupo    TABLE     �   CREATE TABLE public.grupo (
    id integer NOT NULL,
    descricao character varying(800) NOT NULL,
    nome character varying(800) NOT NULL
);
    DROP TABLE public.grupo;
       public            postgres    false            �            1259    39784    grupo_id_seq    SEQUENCE     u   CREATE SEQUENCE public.grupo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.grupo_id_seq;
       public          postgres    false    184            �           0    0    grupo_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.grupo_id_seq OWNED BY public.grupo.id;
          public          postgres    false    183            �            1259    39850    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    39824    loja    TABLE     �   CREATE TABLE public.loja (
    id integer NOT NULL,
    id_empresa integer NOT NULL,
    nome character varying(800) NOT NULL
);
    DROP TABLE public.loja;
       public            postgres    false            �            1259    39822    loja_id_seq    SEQUENCE     t   CREATE SEQUENCE public.loja_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.loja_id_seq;
       public          postgres    false    189            �           0    0    loja_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.loja_id_seq OWNED BY public.loja.id;
          public          postgres    false    188            �            1259    39773    usuario    TABLE     �   CREATE TABLE public.usuario (
    id integer NOT NULL,
    email character varying(255),
    nome character varying(88) NOT NULL,
    senha character varying(255)
);
    DROP TABLE public.usuario;
       public            postgres    false            �            1259    39798    usuario_grupo    TABLE     T   CREATE TABLE public.usuario_grupo (
    usuario_id integer,
    grupo_id integer
);
 !   DROP TABLE public.usuario_grupo;
       public            postgres    false            �            1259    39776    usuario_id_seq    SEQUENCE     w   CREATE SEQUENCE public.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    181            �           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    182                       2604    39816 
   empresa id    DEFAULT     h   ALTER TABLE ONLY public.empresa ALTER COLUMN id SET DEFAULT nextval('public.empresa_id_seq'::regclass);
 9   ALTER TABLE public.empresa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    186    187    187                       2604    39789    grupo id    DEFAULT     d   ALTER TABLE ONLY public.grupo ALTER COLUMN id SET DEFAULT nextval('public.grupo_id_seq'::regclass);
 7   ALTER TABLE public.grupo ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    184    183    184                       2604    39827    loja id    DEFAULT     b   ALTER TABLE ONLY public.loja ALTER COLUMN id SET DEFAULT nextval('public.loja_id_seq'::regclass);
 6   ALTER TABLE public.loja ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    189    188    189                       2604    39778 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    182    181            �          0    39813    empresa 
   TABLE DATA           0   COPY public.empresa (id, nome, nif) FROM stdin;
    public          postgres    false    187   )       �          0    39786    grupo 
   TABLE DATA           4   COPY public.grupo (id, descricao, nome) FROM stdin;
    public          postgres    false    184   Z)       �          0    39824    loja 
   TABLE DATA           4   COPY public.loja (id, id_empresa, nome) FROM stdin;
    public          postgres    false    189   �)       �          0    39773    usuario 
   TABLE DATA           9   COPY public.usuario (id, email, nome, senha) FROM stdin;
    public          postgres    false    181   �)       �          0    39798    usuario_grupo 
   TABLE DATA           =   COPY public.usuario_grupo (usuario_id, grupo_id) FROM stdin;
    public          postgres    false    185   �)       �           0    0    empresa_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.empresa_id_seq', 1, true);
          public          postgres    false    186            �           0    0    grupo_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.grupo_id_seq', 2, true);
          public          postgres    false    183            �           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 14, true);
          public          postgres    false    190            �           0    0    loja_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.loja_id_seq', 1, false);
          public          postgres    false    188            �           0    0    usuario_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.usuario_id_seq', 2, true);
          public          postgres    false    182            
           2606    39821    empresa empresa_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
       public            postgres    false    187                       2606    39794    grupo grupo_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_pkey;
       public            postgres    false    184                       2606    39783 
   usuario id 
   CONSTRAINT     H   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id PRIMARY KEY (id);
 4   ALTER TABLE ONLY public.usuario DROP CONSTRAINT id;
       public            postgres    false    181                       2606    39832    loja loja_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.loja
    ADD CONSTRAINT loja_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.loja DROP CONSTRAINT loja_pkey;
       public            postgres    false    189                       2606    39838    loja empresa_loja    FK CONSTRAINT        ALTER TABLE ONLY public.loja
    ADD CONSTRAINT empresa_loja FOREIGN KEY (id_empresa) REFERENCES public.empresa(id) NOT VALID;
 ;   ALTER TABLE ONLY public.loja DROP CONSTRAINT empresa_loja;
       public          postgres    false    189    187    2058                       2606    39806 )   usuario_grupo usuario_grupo_grupo_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario_grupo
    ADD CONSTRAINT usuario_grupo_grupo_id_fkey FOREIGN KEY (grupo_id) REFERENCES public.grupo(id);
 S   ALTER TABLE ONLY public.usuario_grupo DROP CONSTRAINT usuario_grupo_grupo_id_fkey;
       public          postgres    false    184    2056    185                       2606    39801 +   usuario_grupo usuario_grupo_usuario_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario_grupo
    ADD CONSTRAINT usuario_grupo_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);
 U   ALTER TABLE ONLY public.usuario_grupo DROP CONSTRAINT usuario_grupo_usuario_id_fkey;
       public          postgres    false    2054    181    185            �   /   x�34��w�4516247�24�L���/wO-.��Zp��qqq �w
$      �   ,   x�3�tL����,.)JL�/J-F�sq��楤B$L�=... �T�      �      x������ � �      �   1   x�3�,H,��wH�M���K�υ�!$�gnRi^z"�4D Jq��qqq ,��      �      x�3�4�2�4����� ��     