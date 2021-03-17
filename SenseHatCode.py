import MySQLdb
import time

from sense_hat import SenseHat
sense = SenseHat()


def insert_weather():
    #Getting the temp
    temp = (sense.get_temperature() * 1.8) +32
    print("Temperature: %s F" % round(temp))

    #Getting the humidity
    humidity = sense.get_humidity()
    print("Humidity: %s %%" % round(humidity))

    #Getting the pressure
    pressure = sense.get_pressure()
    print("Pressure: %s Millibars" % round(pressure))

    #orientation
    orientation = sense.get_orientation()
    print("p: {pitch}, r: {roll}, y: {yaw}".format(**orientation))

    #compass
    sense.set_imu_config(True, False, False) #Enable only the compass
    north = sense.get_compass()
    print("North: %s" % north)

    #gyroscope
    sense.set_imu_config(False, True, False) # gyroscope only
    gyro_only = sense.get_gyroscope()
    print("p: {pitch}, r: {roll}, y: {yaw}".format(**gyro_only))

    #accelerometer
    sense.set_imu_config(False, False, True) # accelerometer only
    accel_only = sense.get_accelerometer()
    print("p: {pitch}, r: {roll}, y: {yaw}".format(**accel_only))



    conn = MySQLdb.connect(host="remotemysql.com", user="hHOQMOQDTD", password="f3HJJN4I3c", database="hHOQMOQDTD")
    mycursor = conn.cursor()
    sql = "INSERT INTO weatherInformation (location, Pressure, Tempature, Time) VALUES (%s, %s, %s, %s)"
    val = [
        ('Gilbert', pressure, temp, time.time())
        ]



    mycursor.executemany(sql, val)
    conn.commit()
    conn.close()


while True:
    insert_weather()
    print("Wait 15 Minutes.")
    time.sleep(900)
    


