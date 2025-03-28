create table admin
(
    created_at datetime(6)    not null,
    deleted_at datetime(6)    null,
    updated_at datetime(6)    null,
    id         binary(16)     not null
        primary key,
    email      varchar(255)   not null,
    password   varchar(255)   null,
    role       enum ('Admin') null,
    constraint UK_c0r9atamxvbhjjvy5j8da1kam
        unique (email)
);

create table building
(
    capacity              int          null,
    production_per_minute float        null,
    created_at            datetime(6)  not null,
    deleted_at            datetime(6)  null,
    updated_at            datetime(6)  null,
    id                    binary(16)   not null
        primary key,
    recipe                binary(16)   null,
    dtype                 varchar(31)  not null,
    name                  varchar(255) not null,
    remarks               varchar(255) null,
    slug                  varchar(255) not null,
    constraint UK_dhln7gqbq9qt5lf8a28d0fy99
        unique (slug),
    constraint UK_ntxjs38j4ae4ewq5w8p915ij3
        unique (recipe)
);

create table good
(
    is_map_resource tinyint(1)   not null,
    created_at      datetime(6)  not null,
    deleted_at      datetime(6)  null,
    updated_at      datetime(6)  null,
    id              binary(16)   not null
        primary key,
    name            varchar(255) not null,
    remarks         varchar(255) null,
    slug            varchar(255) not null,
    constraint UK_s6la9h5sjmb40l2ldyrdgrvum
        unique (slug)
);

create table cost_building_goods
(
    amount      int         null,
    created_at  datetime(6) not null,
    deleted_at  datetime(6) null,
    updated_at  datetime(6) null,
    building_id binary(16)  null,
    good_id     binary(16)  null,
    id          binary(16)  not null
        primary key,
    constraint FKp6middi6ytdu6swae7vij962a
        foreign key (building_id) references building (id),
    constraint FKsbw6dqvuqebpntsjumc7g7mmt
        foreign key (good_id) references good (id)
);

create table population
(
    created_at datetime(6)  not null,
    deleted_at datetime(6)  null,
    updated_at datetime(6)  null,
    id         binary(16)   not null
        primary key,
    name       varchar(255) not null,
    slug       varchar(255) not null,
    constraint UK_m9q869h9yj6e396uevaj0grdp
        unique (slug)
);

create table population_requirement
(
    consumption   float       null,
    is_basic      bit         null,
    produce       float       null,
    created_at    datetime(6) not null,
    deleted_at    datetime(6) null,
    updated_at    datetime(6) null,
    good_id       binary(16)  null,
    id            binary(16)  not null
        primary key,
    population_id binary(16)  null,
    constraint FKanqh1no2fb1ouj1cup4sbi6hb
        foreign key (population_id) references population (id),
    constraint FKbcr71dxrg9y3h2av04oasti89
        foreign key (good_id) references good (id)
);

create table recipe
(
    quantity_of_input_1  int          null,
    quantity_of_input_10 int          null,
    quantity_of_input_2  int          null,
    quantity_of_input_3  int          null,
    quantity_of_input_4  int          null,
    quantity_of_input_5  int          null,
    quantity_of_input_6  int          null,
    quantity_of_input_7  int          null,
    quantity_of_input_8  int          null,
    quantity_of_input_9  int          null,
    created_at           datetime(6)  not null,
    deleted_at           datetime(6)  null,
    updated_at           datetime(6)  null,
    id                   binary(16)   not null
        primary key,
    input_1              binary(16)   null,
    input_10             binary(16)   null,
    input_2              binary(16)   null,
    input_3              binary(16)   null,
    input_4              binary(16)   null,
    input_5              binary(16)   null,
    input_6              binary(16)   null,
    input_7              binary(16)   null,
    input_8              binary(16)   null,
    input_9              binary(16)   null,
    output               binary(16)   not null,
    production_building  binary(16)   null,
    name                 varchar(255) not null,
    slug                 varchar(255) not null,
    constraint UK_f4dq4cgv6n33926akdk7gp20s
        unique (production_building),
    constraint UK_r6fr7vfovs1k2wq7bjeqberj5
        unique (slug),
    constraint FK1s1ofha5wphx7x3shtuewr8tg
        foreign key (input_5) references good (id),
    constraint FK5mwifdj5qx2fsxinpo8wv3ujk
        foreign key (input_6) references good (id),
    constraint FK601j7ligefitu7kjynnjjkful
        foreign key (input_8) references good (id),
    constraint FKaf9qawkonlo2biqrfmaqkgnac
        foreign key (input_7) references good (id),
    constraint FKdr36q569c4aw810t4w7v8rl5v
        foreign key (output) references good (id),
    constraint FKk2dnvk7u98noftg1hx6k76i62
        foreign key (input_1) references good (id),
    constraint FKl9pixcpqdeytt2l6y34xh82ti
        foreign key (input_4) references good (id),
    constraint FKldrekctvk1mxgc90yef310boa
        foreign key (input_9) references good (id),
    constraint FKoslhn6r9w7ln2o3cs6k3lp7qw
        foreign key (input_10) references good (id),
    constraint FKq698ebgk1yrcrttqcuxtyiukc
        foreign key (input_3) references good (id),
    constraint FKr1w9rj2jdk3te3bdfbk42lc7y
        foreign key (input_2) references good (id),
    constraint FKrlc0eox7eht7lcydxamlduwrh
        foreign key (production_building) references building (id)
);

alter table building
    add constraint FKoqb8j1mlnygdpoj0gemfh3jls
        foreign key (recipe) references recipe (id);

create table requirement_population_building
(
    amount        int         null,
    created_at    datetime(6) not null,
    deleted_at    datetime(6) null,
    updated_at    datetime(6) null,
    building_id   binary(16)  null,
    id            binary(16)  not null
        primary key,
    population_id binary(16)  null,
    constraint UK_h2xp8yfvhi2ygiaa5a03ksqb2
        unique (building_id),
    constraint FK4jrfuw2qd2g453dbwe827d89i
        foreign key (population_id) references population (id),
    constraint FKfax1aoc78u08wa8klwl1v9mfw
        foreign key (building_id) references building (id)
);

