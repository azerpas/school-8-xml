# http://www.w3.org/2001/XMLSchema
Will be used to define another schema

- `element`
- `complexType`
- `sequence`
- `schema`
- `string`
- `integer`
- `boolean`

for example

## http://www.books.org
Which will contain custom elements

- `BookStore`
- `Book`
- `Title`
- `Author`
- `Publisher`
- `ISBN`
- `Date`

```xml
<?xml version="1.0"?>
<schema xmlns="http://www.w3.org/2001/XMLSchema"
               targetNamespace="http://www.books.org"
               xmlns:bk="http://www.books.org"
               elementFormDefault="qualified">
    <element name="BookStore">
        <complexType>
            <sequence>
                <element ref="bk:Book" minOccurs="1" maxOccurs="unbounded"/>
            </sequence>
        </complexType>
    </element>
    <element name="Book">
        <complexType>
            <sequence>
                <element ref="bk:Title"/>
                <element ref="bk:Author"/>
                <element ref="bk:Date"/>
                <element ref="bk:ISBN"/>
                <element ref="bk:Publisher"/>
            </sequence>
        </complexType>
    </element>
    <element name="Title" type="string"/>
    <element name="Author" type="string"/>
    <element name="Date" type="string"/>
    <element name="ISBN" type="string"/>
    <element name="Publisher" type="string"/>
</schema>
```

And defined as an instance by `XMLSchema-instance`

## https://www.w3.org/2001/XMLSchema-instance
Defines the data
- `schemaLocation`
- `type`
- `noNamespaceSchemaLocation`
- `nil`

### Example for `books`

```xml
<?xml version="1 .0 "?>
<BookStore xmlns="http://www.books.org" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.books.org BookStore.xsd">
    <Book>
        <Title>MyLifeandTimes</Title>
        <Author>PaulMcCartney</Author>
        <Date>July,1998</Date>
        <ISBN>94303-12021-43892</ISBN>
        <Publisher>McMillinPublishing</Publisher>
    </Book>
</BookStore>
```