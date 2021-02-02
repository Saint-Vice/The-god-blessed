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
