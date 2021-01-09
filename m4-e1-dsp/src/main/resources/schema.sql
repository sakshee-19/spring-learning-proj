create table if not exists candy (
    id bigint not null,
    name nvarchar(255),
    price decimal(12,4),
    primary key (id)
);

create table if not exists candy_delivery_map(
    candy_id bigint not null,
    delivery_id bigint not null,
    primary key(candy_id, delivery_id),
    FOREIGN KEY(candy_id) REFERENCES candy(id),
    FOREIGN KEY(delivery_id) REFERENCES delivery(id) on delete cascade
);
