from server import Server

PORT = 22223
CLIENT_PORT = 22222

if __name__ == "__main__":
    server = Server((CLIENT_PORT, PORT))
    server.listening()