#!/bin/bash
sudo docker compose up -d
sudo docker cp backup.sql postgres-container:/backup.sql
sudo docker exec -it postgres-container psql -U postgres -d zenith-store -f /backup.sql 
