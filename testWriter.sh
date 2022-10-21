#!/bin/bash


for (( i=1; i<=150; i++ ))
do
	c=$(curl -s -X POST http://127.0.0.1:8080/customer/create -d "name=pepe&country=ES" | jq -r '.id')
	
	for (( n=1; n<=100; n++ ))
	do
		o=$(curl -s -X POST http://127.0.0.1:8080/order/create -d "customerId=$c&total=$n")
	done
	
echo -n "."
done

