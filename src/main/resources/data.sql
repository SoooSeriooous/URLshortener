CREATE TABLE urls
(
    id IDENTITY,
    url varchar not null,
    short_url varchar(10) not null,
    constraint urls_pk primary key (id)
);

CREATE TABLE statistics
(
    id IDENTITY,
    short_url varchar(10) not null,
    constraint statistics_pk primary key (id)
);

CREATE INDEX idx_statistics_short_url ON statistics(short_url);
CREATE INDEX idx_urls_short_url ON urls(short_url);