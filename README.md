This web application allows the user to quickly search through a large dataset using ElasticSearch.  
The backend repository: https://github.com/PisaniValentin/Movie-Backend  

The Elastic search configuration used for this project:  
<pre>
  <code>
  {  
  "settings": {
    "analysis":{
      "filter":{
        "ngram_filter":{  
          "type":"edge_ngram",  
          "min_gram":1,  
          "max_gram":9  
        }  
      },  
      "analyzer":{  
        "ngram_analyzer":{  
          "type":"custom",  
          "tokenizer":"standard",  
          "filter":[  
             "lowercase",  
            "ngram_filter"]  
        }  
      }  
    }  
  }  
} 
and the mapping  
{  
  "properties": {  
    "country": {  
      "type": "text",  
      "analyzer": "ngram_analyzer"  
    },  
    "title": {  
      "type": "text",  
      "analyzer": "ngram_analyzer"  
    },  
    "description": {  
      "type": "text",  
      "analyzer": "ngram_analyzer"  
    }  
  }  
}  
  </code>
</pre>
<code>
