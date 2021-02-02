import socket
from client import Client

CLIENT_PORT = 22222

if __name__ == "__main__":
    client = Client(CLIENT_PORT)