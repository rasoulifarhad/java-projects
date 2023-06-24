See [Datafaker 2.0](https://dzone.com/articles/datafaker-20)

See [Datafaker github](https://github.com/datafaker-net/datafaker)

A **Schema** is a set of rules that describe what needs to be done to convert data from a Datafaker format to one of the supported formats. One of the main advantages of a schema is that the same schema can be used to convert to different formats.

In Datafaker, each format has its own **Transformer** implementation. Datafaker supports 6 formats, which means there are also six Transformer implementations, namely: 

- **CSV** (CsvTransformer)
- **JSON** (JsonTrasformer)
- **SQL** (SqlTransformer)
- **YAML** (YamlTransformer)
- **XML** (XmlTransformer)
- **Java Object** (JavaObjectTransformer)
