# kafka-k8s-monitoring

## Initial setup
`kubectl create ns playground`

`kubectl -n playground apply -f setup`
`kubectl -n playground apply -f reporting-backends`

## Grafana

`kubectl -n playground port-forward $(kubectl -n playground get po -lname=grafana -o jsonpath="{.items[0].metadata.name}") 3000:3000`

Add datasource named "prometheus"

## Consuming sample data

`kubectl -n playground apply -f job`

### Checking we are getting data
`kubectl -n playground run --rm -it kafkacatjob --image=solsson/kafkacat --restart=OnFailure --command -- kafkacat -C -b kafka -t orders -o -10 -e`

`kubectl -n playground apply -f consumer`

## Prometheus

`kubectl -n playground port-forward $(kubectl -n playground get po -lname=prometheus -o jsonpath="{.items[0].metadata.name}") 9090:9090`