import time
import random
from threading import Thread
class MyThread( Thread ):
    def __init__( self, msg ):
        self.msg = msg
        Thread.__init__(self)
        
    def run( self ):
        for i in range(5):
                time.sleep(0.2 * random.random())
                print(self.msg+str(i)+ " ")
              
li = [ MyThread( "Peter" ), MyThread( "Mary" ), MyThread( "Paul" ) ]

list( map( (lambda x: x.start()), li))
list( map( (lambda x: x.join()), li))


print('All 3 child thread have ended')
