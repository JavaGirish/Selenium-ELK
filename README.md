## Selenium-ELK Integration 

Selenium Java data driven framework implemented using Page Object Model Design Pattern using TestNG, Maven. <br>
Excel sheet is used for data driving the scripts, test cases to be executed can be set to Yes in the RunManager worksheet. <br>
Custom listeners added: Method Interceptor, RetryAnalyzer and Annotation Transformer implemented <br>


##ELK Integration <br>
Install [ELK](https://www.elastic.co/guide/en/elastic-stack-get-started/current/get-started-elastic-stack.html#install-kibana) in an AWS EC2 instance using Docker <br>
Elastic Search can be accessed from port: 9200 and Kibana can be accessed from port: 5601

```bash
docker run -p 9200:9200 -p 9300:9300 --name elasticsearch -e "discovery.type=single-node"  docker.elastic.co/elasticsearch/elasticsearch:7.11.1

docker run -p 5601:5601 --name kibana --link elasticsearch:elasticsearch docker.elastic.co/kibana/kibana:7.11.1

```




