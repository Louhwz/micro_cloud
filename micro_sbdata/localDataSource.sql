DROP TABLE IF EXISTS sbdata_ready_status;
DROP TABLE IF EXISTS sbdata_room_orders;

CREATE TABLE sbdata_room_orders{
    id int NOT NULL AUTO_INCREMENT,
    expid int,
    groupid int,
    round int,
    customer_id int,
    room_id int,
    price int,
    PRIMARY KEY(ID)
}

CREATE TABLE sbdata_ready_status{
    id int NOT NULL AUTO_INCREMENT,

}
