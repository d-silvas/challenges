import multiprocessing
from time import sleep


def task(process_number):
    sleep(1)
    print(f"Process {process_number}")


if __name__ == "__main__":
    """
    Test file for trying out multiprocessing
    As seen in https://superfastpython.com/multiprocessing-in-python/
    """
    for i in range(1, 5):
        process = multiprocessing.Process(target=task, kwargs={"process_number": i})
        process.start()
        process.join()  # Blocks the execution of this program until process ends
