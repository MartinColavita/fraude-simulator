```toml
name = 'checkTransaction'
method = 'POST'
url = 'http://localhost:8080/api/merchants/transaction'
sortWeight = 1000000
id = 'e27c8822-562e-48a9-bdbb-e4068a680461'

[[headers]]
key = 'Content-Type'
value = 'application/json'

[body]
type = 'JSON'
raw = '''
{
    "terminalId": "T456"
}'''
```
