for i in {1..20}
  do
    curl --location --request POST $1 --header 'Content-Type: application/json' --data-raw '{"data":"AWS Community Day - This is a sample record"}'
    echo "ji ${i}"
	  sleep 4
  done
