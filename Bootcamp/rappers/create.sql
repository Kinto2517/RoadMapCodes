
    create table cat (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table rapper (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table song (
       id bigint generated by default as identity,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    );

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat;

    alter table song 
       add constraint FKeyfme0pqclnfqymb4enih9o13 
       foreign key (rapper_id) 
       references rapper;

    create table cat (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table rapper (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table song (
       id bigint generated by default as identity,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    );

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat;

    alter table song 
       add constraint FKeyfme0pqclnfqymb4enih9o13 
       foreign key (rapper_id) 
       references rapper;

    create table cat (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table rapper (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table song (
       id bigint generated by default as identity,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    );

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat;

    alter table song 
       add constraint FKeyfme0pqclnfqymb4enih9o13 
       foreign key (rapper_id) 
       references rapper;

    create table cat (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table rapper (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table song (
       id bigint generated by default as identity,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    );

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat;

    alter table song 
       add constraint FKeyfme0pqclnfqymb4enih9o13 
       foreign key (rapper_id) 
       references rapper;

    create table cat (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table rapper (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table song (
       id bigint generated by default as identity,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    );

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat;

    alter table song 
       add constraint FKeyfme0pqclnfqymb4enih9o13 
       foreign key (rapper_id) 
       references rapper;

    create table cat (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table rapper (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table song (
       id bigint generated by default as identity,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    );

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat;

    alter table song 
       add constraint FKeyfme0pqclnfqymb4enih9o13 
       foreign key (rapper_id) 
       references rapper;

    create table rappers.rappers (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table cat (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table song (
       id bigint generated by default as identity,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    );

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat;

    alter table song 
       add constraint FKlsjh3t861ada4evdbk82ohgqs 
       foreign key (rapper_id) 
       references rappers.rappers;

    create table rappers.rappers (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table cat (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table song (
       id bigint generated by default as identity,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    );

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat;

    alter table song 
       add constraint FKlsjh3t861ada4evdbk82ohgqs 
       foreign key (rapper_id) 
       references rappers.rappers;

    create table rappers.rappers (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table cat (
       id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );

    create table song (
       id bigint generated by default as identity,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    );

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat;

    alter table song 
       add constraint FKlsjh3t861ada4evdbk82ohgqs 
       foreign key (rapper_id) 
       references rappers.rappers;

    create table cat (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table rappers (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table song (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat (id);

    alter table song 
       add constraint FKlsjh3t861ada4evdbk82ohgqs 
       foreign key (rapper_id) 
       references rappers (id);

    create table cat (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table rapper (
       id bigint not null auto_increment,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table song (
       id bigint not null auto_increment,
        name varchar(255),
        type varchar(255),
        cat_id bigint,
        rapper_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id bigint not null,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table song 
       add constraint FKiok4r24383lol1akpk3htlr4c 
       foreign key (cat_id) 
       references cat (id);

    alter table song 
       add constraint FKeyfme0pqclnfqymb4enih9o13 
       foreign key (rapper_id) 
       references rapper (id);