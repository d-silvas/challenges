import time


class Performance:
    """
    TODO support different timers based on name
    TODO support report_progress function for long calculations
    TODO improve displayed time depending on units (min/s/ms/ns)
    """

    init_time: int

    def start(self):
        self.init_time = time.perf_counter_ns()

    def end(self):
        end_time = time.perf_counter_ns()
        print(f"{(end_time - self.init_time)/(10 ** 6)}ms")
