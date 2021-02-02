## Protocol LAB2
The protocol stack
#### Transport Level
In trans.transport.py a protocol atop UDP with UDP Client and UDP Server with error checking and retransmission. 

```python
def get_cksm(val):
    try:
        val_b = val.encode('utf-8')
    except (UnicodeDecodeError, AttributeError):
        val_b = val
    return hashlib.md5(val_b).hexdigest()


def make_packet(val):
    return pickle.dumps({
        'cksm': get_cksm(val),
        'payload': val,
    })


def is_valid(packet):
    return packet['cksm'] == get_cksm(packet['payload'])
```

#### Session Level
For session level I implemented Diffie Hellman algorithm for safety reasons.
```python
 class DiffieHellman:

    def __init__(self):
        self.modulus = 8291
        self.base = 1117

    def generate_key(self, secret):
        key = int(pow(self.base, secret, self.modulus))
        return key

    def get_secret_key(self, key, secret):
        secr_key = int(pow(key, secret, self.modulus))
        return secr_key

    def encrypted(self, msg, key):
        ency_bytes = []
        data = msg.encode('utf-8')
        for byt in data:
            ency_bytes.append(byt + key)
        return ency_bytes

    def decrypted(self, data, key):
        msg = ''
        for byt in data:
            msg += chr(byt - key)
        return msg

```
The key is generated at both Client and Server. They exchange their public keys which are generated while running the run_client.py and run_server.py and combine them with their private keys.

