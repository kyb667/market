\c market

create table admin_info (
  admin_id character varying not null
  , admin_password character varying not null
  , admin_name character varying not null
  , created_by character varying
  , created_at timestamp(6) without time zone
  , updated_by character varying
  , updated_at timestamp(6) without time zone
  , constraint admin_info_PKC primary key (admin_id)
);

comment on table admin_info is 'admin 정보';
comment on column admin_info.admin_id is '아이디';
comment on column admin_info.admin_password is '비밀번호';
comment on column admin_info.admin_name is '유저명';
comment on column admin_info.created_by is '등록자';
comment on column admin_info.created_at is '등록시간';
comment on column admin_info.updated_by is '갱신자';
comment on column admin_info.updated_at is '갱신시간';


create table buyer_info (
  buyer_email character varying default '' 
  , buyer_id character varying default ''
  , buyer_password character varying not null
  , buyer_login_type character varying default '1'
  , buyer_name character varying not null
  , phone character varying not null
  , created_by character varying
  , created_at timestamp(6) without time zone
  , updated_by character varying
  , updated_at timestamp(6) without time zone
  , constraint buyer_info_PKC primary key (buyer_email, buyer_id, buyer_login_type)
);

comment on table buyer_info is '구매자 정보';
comment on column buyer_info.buyer_email is '이메일';
comment on column buyer_info.buyer_id is '아이디';
comment on column buyer_info.buyer_password is '비밀번호';
comment on column buyer_info.buyer_login_type is '로그인 타입 (1 : id , 2: email)';
comment on column buyer_info.buyer_name is '유저명';
comment on column buyer_info.phone is '핸드폰번호';
comment on column buyer_info.created_by is '등록자';
comment on column buyer_info.created_at is '등록시간';
comment on column buyer_info.updated_by is '갱신자';
comment on column buyer_info.updated_at is '갱신시간';