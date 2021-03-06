PGDMP     0                    x            gestao_venda    9.5.22     12.3 (Ubuntu 12.3-1.pgdg20.04+1) y    &	           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            '	           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            (	           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            )	           1262    31581    gestao_venda    DATABASE     ~   CREATE DATABASE gestao_venda WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_PT.UTF-8' LC_CTYPE = 'pt_PT.UTF-8';
    DROP DATABASE gestao_venda;
                postgres    false            *	           0    0    SCHEMA public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   postgres    false    6            �            1259    48195    caixa    TABLE     �   CREATE TABLE public.caixa (
    id bigint NOT NULL,
    data_abertura timestamp without time zone,
    data_fecho timestamp without time zone,
    saldo numeric(19,2),
    id_funcionario bigint NOT NULL,
    id_loja bigint NOT NULL
);
    DROP TABLE public.caixa;
       public            postgres    false            �            1259    48193    caixa_id_seq    SEQUENCE     u   CREATE SEQUENCE public.caixa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.caixa_id_seq;
       public          postgres    false    212            +	           0    0    caixa_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.caixa_id_seq OWNED BY public.caixa.id;
          public          postgres    false    211            �            1259    48151    cliente    TABLE     �   CREATE TABLE public.cliente (
    id bigint NOT NULL,
    contacto character varying(255),
    nif character varying(20) NOT NULL,
    nome character varying(800) NOT NULL,
    id_tipo_cliente bigint NOT NULL
);
    DROP TABLE public.cliente;
       public            postgres    false            �            1259    48149    cliente_id_seq    SEQUENCE     w   CREATE SEQUENCE public.cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public          postgres    false    208            ,	           0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          postgres    false    207            �            1259    39813    empresa    TABLE     �   CREATE TABLE public.empresa (
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
       public          postgres    false    187            -	           0    0    empresa_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.empresa_id_seq OWNED BY public.empresa.id;
          public          postgres    false    186            �            1259    48167    estoque    TABLE     �  CREATE TABLE public.estoque (
    id bigint NOT NULL,
    data_compra timestamp without time zone,
    estoque_max integer NOT NULL,
    estoque_min integer NOT NULL,
    peso numeric(19,2),
    qtd_actual integer NOT NULL,
    valor_custo numeric(19,2),
    valor_venda numeric(19,2),
    id_fornecedor bigint NOT NULL,
    id_loja bigint NOT NULL,
    id_produto bigint NOT NULL,
    id_unidadeproduto bigint NOT NULL
);
    DROP TABLE public.estoque;
       public            postgres    false            �            1259    48165    estoque_id_seq    SEQUENCE     w   CREATE SEQUENCE public.estoque_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.estoque_id_seq;
       public          postgres    false    210            .	           0    0    estoque_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.estoque_id_seq OWNED BY public.estoque.id;
          public          postgres    false    209            �            1259    39894    forma_pagamento_id_seq    SEQUENCE        CREATE SEQUENCE public.forma_pagamento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.forma_pagamento_id_seq;
       public          postgres    false            �            1259    39896    forma_pagamento    TABLE     �   CREATE TABLE public.forma_pagamento (
    id integer DEFAULT nextval('public.forma_pagamento_id_seq'::regclass) NOT NULL,
    descricao character varying(800) NOT NULL
);
 #   DROP TABLE public.forma_pagamento;
       public            postgres    false    193            �            1259    39916    fornecedor_id_seq    SEQUENCE     z   CREATE SEQUENCE public.fornecedor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.fornecedor_id_seq;
       public          postgres    false            �            1259    39918 
   fornecedor    TABLE     �   CREATE TABLE public.fornecedor (
    id integer DEFAULT nextval('public.fornecedor_id_seq'::regclass) NOT NULL,
    nome character varying(800) NOT NULL,
    nif character varying(20) NOT NULL
);
    DROP TABLE public.fornecedor;
       public            postgres    false    197            �            1259    39860    funcionario_id_seq    SEQUENCE     {   CREATE SEQUENCE public.funcionario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.funcionario_id_seq;
       public          postgres    false            �            1259    39880    funcionario    TABLE     "  CREATE TABLE public.funcionario (
    id integer DEFAULT nextval('public.funcionario_id_seq'::regclass) NOT NULL,
    id_loja integer NOT NULL,
    nome character varying(800) NOT NULL,
    telefone character varying(20),
    data_nascimento date,
    sexo character varying(9) NOT NULL
);
    DROP TABLE public.funcionario;
       public            postgres    false    191            �            1259    39786    grupo    TABLE     �   CREATE TABLE public.grupo (
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
       public          postgres    false    184            /	           0    0    grupo_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.grupo_id_seq OWNED BY public.grupo.id;
          public          postgres    false    183            �            1259    39945    grupo_produto_id_seq    SEQUENCE     }   CREATE SEQUENCE public.grupo_produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.grupo_produto_id_seq;
       public          postgres    false            �            1259    39947    grupo_produto    TABLE     �   CREATE TABLE public.grupo_produto (
    id integer DEFAULT nextval('public.grupo_produto_id_seq'::regclass) NOT NULL,
    descricao character varying(800) NOT NULL
);
 !   DROP TABLE public.grupo_produto;
       public            postgres    false    201            �            1259    39850    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
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
       public          postgres    false    189            0	           0    0    loja_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE public.loja_id_seq OWNED BY public.loja.id;
          public          postgres    false    188            �            1259    48203    movimentos_caixa    TABLE     �   CREATE TABLE public.movimentos_caixa (
    id bigint NOT NULL,
    data timestamp without time zone,
    movimento character varying(255),
    valor numeric(19,2),
    id_caixa bigint NOT NULL,
    id_formapagamento bigint NOT NULL
);
 $   DROP TABLE public.movimentos_caixa;
       public            postgres    false            �            1259    48201    movimentos_caixa_id_seq    SEQUENCE     �   CREATE SEQUENCE public.movimentos_caixa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.movimentos_caixa_id_seq;
       public          postgres    false    214            1	           0    0    movimentos_caixa_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.movimentos_caixa_id_seq OWNED BY public.movimentos_caixa.id;
          public          postgres    false    213            �            1259    48121    produto    TABLE     �   CREATE TABLE public.produto (
    id bigint NOT NULL,
    activo_para_venda boolean NOT NULL,
    codigo_interno character varying(255),
    descricao character varying(255),
    id_grupo_produto bigint NOT NULL
);
    DROP TABLE public.produto;
       public            postgres    false            �            1259    48119    produto_id_seq    SEQUENCE     w   CREATE SEQUENCE public.produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.produto_id_seq;
       public          postgres    false    206            2	           0    0    produto_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;
          public          postgres    false    205            �            1259    48108    servico_id_seq    SEQUENCE     w   CREATE SEQUENCE public.servico_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.servico_id_seq;
       public          postgres    false            �            1259    48110    servico    TABLE     =  CREATE TABLE public.servico (
    id integer DEFAULT nextval('public.servico_id_seq'::regclass) NOT NULL,
    descricao character varying(800) NOT NULL,
    codigo_interno character varying(45) NOT NULL,
    valor_custo numeric(19,2) NOT NULL,
    valor_venda numeric(19,2) NOT NULL,
    activo_para_venda boolean
);
    DROP TABLE public.servico;
       public            postgres    false    203            �            1259    39930    tipo_cliente_id_seq    SEQUENCE     |   CREATE SEQUENCE public.tipo_cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.tipo_cliente_id_seq;
       public          postgres    false            �            1259    39932    tipo_cliente    TABLE     �   CREATE TABLE public.tipo_cliente (
    id integer DEFAULT nextval('public.tipo_cliente_id_seq'::regclass) NOT NULL,
    descricao character varying(800) NOT NULL
);
     DROP TABLE public.tipo_cliente;
       public            postgres    false    199            �            1259    39905    unidade_produto_id_seq    SEQUENCE        CREATE SEQUENCE public.unidade_produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.unidade_produto_id_seq;
       public          postgres    false            �            1259    39907    unidade_produto    TABLE     �   CREATE TABLE public.unidade_produto (
    id integer DEFAULT nextval('public.unidade_produto_id_seq'::regclass) NOT NULL,
    descricao character varying(800) NOT NULL
);
 #   DROP TABLE public.unidade_produto;
       public            postgres    false    195            �            1259    39773    usuario    TABLE     �   CREATE TABLE public.usuario (
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
       public          postgres    false    181            3	           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    182            `           2604    48198    caixa id    DEFAULT     d   ALTER TABLE ONLY public.caixa ALTER COLUMN id SET DEFAULT nextval('public.caixa_id_seq'::regclass);
 7   ALTER TABLE public.caixa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    212    212            ^           2604    48154 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    208    208            T           2604    39816 
   empresa id    DEFAULT     h   ALTER TABLE ONLY public.empresa ALTER COLUMN id SET DEFAULT nextval('public.empresa_id_seq'::regclass);
 9   ALTER TABLE public.empresa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    186    187    187            _           2604    48170 
   estoque id    DEFAULT     h   ALTER TABLE ONLY public.estoque ALTER COLUMN id SET DEFAULT nextval('public.estoque_id_seq'::regclass);
 9   ALTER TABLE public.estoque ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    210    210            S           2604    39789    grupo id    DEFAULT     d   ALTER TABLE ONLY public.grupo ALTER COLUMN id SET DEFAULT nextval('public.grupo_id_seq'::regclass);
 7   ALTER TABLE public.grupo ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    183    184    184            U           2604    39827    loja id    DEFAULT     b   ALTER TABLE ONLY public.loja ALTER COLUMN id SET DEFAULT nextval('public.loja_id_seq'::regclass);
 6   ALTER TABLE public.loja ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    189    188    189            a           2604    48206    movimentos_caixa id    DEFAULT     z   ALTER TABLE ONLY public.movimentos_caixa ALTER COLUMN id SET DEFAULT nextval('public.movimentos_caixa_id_seq'::regclass);
 B   ALTER TABLE public.movimentos_caixa ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    213    214            ]           2604    48124 
   produto id    DEFAULT     h   ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);
 9   ALTER TABLE public.produto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    206    206            R           2604    39778 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    182    181            !	          0    48195    caixa 
   TABLE DATA           ^   COPY public.caixa (id, data_abertura, data_fecho, saldo, id_funcionario, id_loja) FROM stdin;
    public          postgres    false    212   ��       	          0    48151    cliente 
   TABLE DATA           K   COPY public.cliente (id, contacto, nif, nome, id_tipo_cliente) FROM stdin;
    public          postgres    false    208   �       	          0    39813    empresa 
   TABLE DATA           0   COPY public.empresa (id, nome, nif) FROM stdin;
    public          postgres    false    187   }�       	          0    48167    estoque 
   TABLE DATA           �   COPY public.estoque (id, data_compra, estoque_max, estoque_min, peso, qtd_actual, valor_custo, valor_venda, id_fornecedor, id_loja, id_produto, id_unidadeproduto) FROM stdin;
    public          postgres    false    210   Њ       	          0    39896    forma_pagamento 
   TABLE DATA           8   COPY public.forma_pagamento (id, descricao) FROM stdin;
    public          postgres    false    194   >�       	          0    39918 
   fornecedor 
   TABLE DATA           3   COPY public.fornecedor (id, nome, nif) FROM stdin;
    public          postgres    false    198   v�       	          0    39880    funcionario 
   TABLE DATA           Y   COPY public.funcionario (id, id_loja, nome, telefone, data_nascimento, sexo) FROM stdin;
    public          postgres    false    192   ��       	          0    39786    grupo 
   TABLE DATA           4   COPY public.grupo (id, descricao, nome) FROM stdin;
    public          postgres    false    184   "�       	          0    39947    grupo_produto 
   TABLE DATA           6   COPY public.grupo_produto (id, descricao) FROM stdin;
    public          postgres    false    202   ^�       
	          0    39824    loja 
   TABLE DATA           4   COPY public.loja (id, id_empresa, nome) FROM stdin;
    public          postgres    false    189   ��       #	          0    48203    movimentos_caixa 
   TABLE DATA           c   COPY public.movimentos_caixa (id, data, movimento, valor, id_caixa, id_formapagamento) FROM stdin;
    public          postgres    false    214   Ì       	          0    48121    produto 
   TABLE DATA           e   COPY public.produto (id, activo_para_venda, codigo_interno, descricao, id_grupo_produto) FROM stdin;
    public          postgres    false    206   ��       	          0    48110    servico 
   TABLE DATA           m   COPY public.servico (id, descricao, codigo_interno, valor_custo, valor_venda, activo_para_venda) FROM stdin;
    public          postgres    false    204   %�       	          0    39932    tipo_cliente 
   TABLE DATA           5   COPY public.tipo_cliente (id, descricao) FROM stdin;
    public          postgres    false    200   p�       	          0    39907    unidade_produto 
   TABLE DATA           8   COPY public.unidade_produto (id, descricao) FROM stdin;
    public          postgres    false    196   ��       	          0    39773    usuario 
   TABLE DATA           9   COPY public.usuario (id, email, nome, senha) FROM stdin;
    public          postgres    false    181   Í       	          0    39798    usuario_grupo 
   TABLE DATA           =   COPY public.usuario_grupo (usuario_id, grupo_id) FROM stdin;
    public          postgres    false    185   �       4	           0    0    caixa_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.caixa_id_seq', 1, false);
          public          postgres    false    211            5	           0    0    cliente_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cliente_id_seq', 3, true);
          public          postgres    false    207            6	           0    0    empresa_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.empresa_id_seq', 2, true);
          public          postgres    false    186            7	           0    0    estoque_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.estoque_id_seq', 5, true);
          public          postgres    false    209            8	           0    0    forma_pagamento_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.forma_pagamento_id_seq', 3, true);
          public          postgres    false    193            9	           0    0    fornecedor_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.fornecedor_id_seq', 3, true);
          public          postgres    false    197            :	           0    0    funcionario_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.funcionario_id_seq', 2, true);
          public          postgres    false    191            ;	           0    0    grupo_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.grupo_id_seq', 2, true);
          public          postgres    false    183            <	           0    0    grupo_produto_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.grupo_produto_id_seq', 2, true);
          public          postgres    false    201            =	           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 23, true);
          public          postgres    false    190            >	           0    0    loja_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.loja_id_seq', 1, false);
          public          postgres    false    188            ?	           0    0    movimentos_caixa_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.movimentos_caixa_id_seq', 1, false);
          public          postgres    false    213            @	           0    0    produto_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.produto_id_seq', 2, true);
          public          postgres    false    205            A	           0    0    servico_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.servico_id_seq', 3, true);
          public          postgres    false    203            B	           0    0    tipo_cliente_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tipo_cliente_id_seq', 3, true);
          public          postgres    false    199            C	           0    0    unidade_produto_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.unidade_produto_id_seq', 2, true);
          public          postgres    false    195            D	           0    0    usuario_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.usuario_id_seq', 2, true);
          public          postgres    false    182                       2606    48200    caixa caixa_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT caixa_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.caixa DROP CONSTRAINT caixa_pkey;
       public            postgres    false    212            {           2606    48159    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    208            g           2606    39821    empresa empresa_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.empresa DROP CONSTRAINT empresa_pkey;
       public            postgres    false    187            }           2606    48172    estoque estoque_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT estoque_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.estoque DROP CONSTRAINT estoque_pkey;
       public            postgres    false    210            m           2606    39904 $   forma_pagamento forma_pagamento_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.forma_pagamento
    ADD CONSTRAINT forma_pagamento_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.forma_pagamento DROP CONSTRAINT forma_pagamento_pkey;
       public            postgres    false    194            q           2606    39926    fornecedor fornecedor_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_pkey;
       public            postgres    false    198            k           2606    39888    funcionario funcionario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
       public            postgres    false    192            e           2606    39794    grupo grupo_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.grupo
    ADD CONSTRAINT grupo_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.grupo DROP CONSTRAINT grupo_pkey;
       public            postgres    false    184            u           2606    39955     grupo_produto grupo_produto_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.grupo_produto
    ADD CONSTRAINT grupo_produto_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.grupo_produto DROP CONSTRAINT grupo_produto_pkey;
       public            postgres    false    202            c           2606    39783 
   usuario id 
   CONSTRAINT     H   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT id PRIMARY KEY (id);
 4   ALTER TABLE ONLY public.usuario DROP CONSTRAINT id;
       public            postgres    false    181            i           2606    39832    loja loja_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.loja
    ADD CONSTRAINT loja_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.loja DROP CONSTRAINT loja_pkey;
       public            postgres    false    189            �           2606    48208 &   movimentos_caixa movimentos_caixa_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.movimentos_caixa
    ADD CONSTRAINT movimentos_caixa_pkey PRIMARY KEY (id);
 P   ALTER TABLE ONLY public.movimentos_caixa DROP CONSTRAINT movimentos_caixa_pkey;
       public            postgres    false    214            y           2606    48129    produto produto_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public            postgres    false    206            w           2606    48118    servico servico_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.servico
    ADD CONSTRAINT servico_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.servico DROP CONSTRAINT servico_pkey;
       public            postgres    false    204            s           2606    39940    tipo_cliente tipo_cliente_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tipo_cliente
    ADD CONSTRAINT tipo_cliente_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.tipo_cliente DROP CONSTRAINT tipo_cliente_pkey;
       public            postgres    false    200            o           2606    39915 $   unidade_produto unidade_produto_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.unidade_produto
    ADD CONSTRAINT unidade_produto_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.unidade_produto DROP CONSTRAINT unidade_produto_pkey;
       public            postgres    false    196            �           2606    39838    loja empresa_loja    FK CONSTRAINT        ALTER TABLE ONLY public.loja
    ADD CONSTRAINT empresa_loja FOREIGN KEY (id_empresa) REFERENCES public.empresa(id) NOT VALID;
 ;   ALTER TABLE ONLY public.loja DROP CONSTRAINT empresa_loja;
       public          postgres    false    189    187    2151            �           2606    48160 #   cliente fk46k6k25yfkq3bvr0qf6b8ub5h    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk46k6k25yfkq3bvr0qf6b8ub5h FOREIGN KEY (id_tipo_cliente) REFERENCES public.tipo_cliente(id);
 M   ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk46k6k25yfkq3bvr0qf6b8ub5h;
       public          postgres    false    208    2163    200            �           2606    48178 #   estoque fk853l3jj3fc18h98gqdhhwvwsa    FK CONSTRAINT     �   ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT fk853l3jj3fc18h98gqdhhwvwsa FOREIGN KEY (id_loja) REFERENCES public.loja(id);
 M   ALTER TABLE ONLY public.estoque DROP CONSTRAINT fk853l3jj3fc18h98gqdhhwvwsa;
       public          postgres    false    2153    210    189            �           2606    48183 #   estoque fkbx8yr35bvoe5dqdd2sxjjjktj    FK CONSTRAINT     �   ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT fkbx8yr35bvoe5dqdd2sxjjjktj FOREIGN KEY (id_produto) REFERENCES public.produto(id);
 M   ALTER TABLE ONLY public.estoque DROP CONSTRAINT fkbx8yr35bvoe5dqdd2sxjjjktj;
       public          postgres    false    2169    206    210            �           2606    48214 !   caixa fkdvnyegt6sob2ku31f5c5orfda    FK CONSTRAINT        ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT fkdvnyegt6sob2ku31f5c5orfda FOREIGN KEY (id_loja) REFERENCES public.loja(id);
 K   ALTER TABLE ONLY public.caixa DROP CONSTRAINT fkdvnyegt6sob2ku31f5c5orfda;
       public          postgres    false    212    189    2153            �           2606    48224 ,   movimentos_caixa fkfvmlm06dsgv97p5o4lug1v61v    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimentos_caixa
    ADD CONSTRAINT fkfvmlm06dsgv97p5o4lug1v61v FOREIGN KEY (id_formapagamento) REFERENCES public.forma_pagamento(id);
 V   ALTER TABLE ONLY public.movimentos_caixa DROP CONSTRAINT fkfvmlm06dsgv97p5o4lug1v61v;
       public          postgres    false    214    2157    194            �           2606    48173 #   estoque fkkjghbigy7rakohq7kh281sv8o    FK CONSTRAINT     �   ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT fkkjghbigy7rakohq7kh281sv8o FOREIGN KEY (id_fornecedor) REFERENCES public.fornecedor(id);
 M   ALTER TABLE ONLY public.estoque DROP CONSTRAINT fkkjghbigy7rakohq7kh281sv8o;
       public          postgres    false    210    198    2161            �           2606    48130 #   produto fkl3lq5mrfc51od57sus4r5w6jm    FK CONSTRAINT     �   ALTER TABLE ONLY public.produto
    ADD CONSTRAINT fkl3lq5mrfc51od57sus4r5w6jm FOREIGN KEY (id_grupo_produto) REFERENCES public.grupo_produto(id);
 M   ALTER TABLE ONLY public.produto DROP CONSTRAINT fkl3lq5mrfc51od57sus4r5w6jm;
       public          postgres    false    202    206    2165            �           2606    48188 #   estoque fkmfw5b5536ea19fku724a4nue9    FK CONSTRAINT     �   ALTER TABLE ONLY public.estoque
    ADD CONSTRAINT fkmfw5b5536ea19fku724a4nue9 FOREIGN KEY (id_unidadeproduto) REFERENCES public.unidade_produto(id);
 M   ALTER TABLE ONLY public.estoque DROP CONSTRAINT fkmfw5b5536ea19fku724a4nue9;
       public          postgres    false    196    210    2159            �           2606    48209 !   caixa fkppaudvshwsa7vj50anunb9vf5    FK CONSTRAINT     �   ALTER TABLE ONLY public.caixa
    ADD CONSTRAINT fkppaudvshwsa7vj50anunb9vf5 FOREIGN KEY (id_funcionario) REFERENCES public.funcionario(id);
 K   ALTER TABLE ONLY public.caixa DROP CONSTRAINT fkppaudvshwsa7vj50anunb9vf5;
       public          postgres    false    192    212    2155            �           2606    48219 +   movimentos_caixa fksubdk2cukxwby8ie8a8ec7qj    FK CONSTRAINT     �   ALTER TABLE ONLY public.movimentos_caixa
    ADD CONSTRAINT fksubdk2cukxwby8ie8a8ec7qj FOREIGN KEY (id_caixa) REFERENCES public.caixa(id);
 U   ALTER TABLE ONLY public.movimentos_caixa DROP CONSTRAINT fksubdk2cukxwby8ie8a8ec7qj;
       public          postgres    false    212    214    2175            �           2606    39889    funcionario loja_funcionario    FK CONSTRAINT     z   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT loja_funcionario FOREIGN KEY (id_loja) REFERENCES public.loja(id);
 F   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT loja_funcionario;
       public          postgres    false    2153    189    192            �           2606    39806 )   usuario_grupo usuario_grupo_grupo_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario_grupo
    ADD CONSTRAINT usuario_grupo_grupo_id_fkey FOREIGN KEY (grupo_id) REFERENCES public.grupo(id);
 S   ALTER TABLE ONLY public.usuario_grupo DROP CONSTRAINT usuario_grupo_grupo_id_fkey;
       public          postgres    false    184    185    2149            �           2606    39801 +   usuario_grupo usuario_grupo_usuario_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario_grupo
    ADD CONSTRAINT usuario_grupo_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);
 U   ALTER TABLE ONLY public.usuario_grupo DROP CONSTRAINT usuario_grupo_usuario_id_fkey;
       public          postgres    false    2147    185    181            !	      x������ � �      	   Z   x��1�  ��}�/0�#Κ� �ƅH������đQ�<���:�
[�k���@P 0�?:+lt�b>KjG��Z}�����Ph3      	   C   x�34�L���/wO-.�451624��22�,((�r͸���(A�ML��8Ã��B��M�jc���� �;H      	   ^   x�m��	� ��d�.�����t�9��Z!����L��P/��#Y ���1B*sQ��Ĵl׶#�t�t�^�|h��V#��S���OT���$�      	   (   x�3�tN,*9�8_��4�$391�"��(X������ �w
C      	   *   x�3��s�4516247�2���,I�	���q��qqq ��o      	   b   x�M�A
�  ���
?`��������l!!�B���[�9�E �Uz�:콜<NH�[���!� ��9��,�y')��&{̿B�dޅ�x��mPJ=��      	   ,   x�3�tL����,.)JL�/J-F�sq��楤B$L�=... �T�      	      x�3�tJM�LI,�����  ��      
	   .   x�3��44����I�MJ�2��44���/*�WpJ�+�W������ ��	s      #	      x������ � �      	   5   x�3�,�t642�tK�+I�4�2����q:�''*8��$b���� 2��      	   ;   x�3��tw�420�3��47 ��%\F�..�������@!cN�TW� U
�      	      x�3��*-�L�L��2�t�,1b���� aR�      	      x�3���,)������ 
�      	   1   x�3�,H,��wH�M���K�υ�!$�gnRi^z"�4D Jq��qqq ,��      	      x�3�4�2�4����� ��     