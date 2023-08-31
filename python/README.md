# Euler Project solutions in Python

Features
- With performance measurement
- Fully tested
- With multithreading

## Virtual environment
Windows instructions

- First setup
```
py -m venv ./.venv
./venv/Scripts/activate.bat
pip install -r requirements.txt
```

- Subsequent runs
```
./venv/Scripts/activate.bat
python euler.py
```

## Tests
```
python -m unittest discover
```


## TODO
- Refactor so I can do other challenges e.g. Leetcode (while being able to use the same utility classes)