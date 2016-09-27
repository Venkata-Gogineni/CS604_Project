#Venkata Gogineni
#Student ID- 0788305
#Cryptography - Prof Kinber
#Lab 1 Assignment

from Crypto.Cipher import AES
import base64
import os

SIZE_BLOCK = 32
#key = b'D7C39820ED431E98A85C5590CBA23626'
key = os.urandom(SIZE_BLOCK)
#key = b'1CC99486DF2819EFC31EC26D7F05D4DC8D801762C4E83A6019DA3A0A3034F350'
#message = 'This is my super secret message and I call it a sweet little one'
cipher = AES.new(key)

message = input("Please enter the secret message: ")

print ("The secret message is: "), message

def padding(text):
    return text + ((SIZE_BLOCK-len(text)%SIZE_BLOCK) * '{')

def encrypt(plaintext):
    global cipher
    return cipher.encrypt(padding(plaintext))

encrypted = encrypt(message)
print(encrypted)

file = open('C:/Python27/encryptedintoFile.txt', 'wb')
file.write(encrypted)
file.close()

ciphertext = open('C:/Python27/encryptedintoFile.txt', 'rb').readlines()
print ("Ciphertext from file is: ", ciphertext)

def decrypt(ciphertext):
    global cipher
    dec = cipher.decrypt(ciphertext).decode('utf-8')
    l = dec.count('{')
    return dec[:len(dec)-l]



decrypted = decrypt(encrypted)

print ("Decrypted is: ",decrypted)