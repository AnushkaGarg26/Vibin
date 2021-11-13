# -*- coding: utf-8 -*-
"""pre-processing_data.py

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1LPkZLA622zNliMAO-V2KPLdfiQujAEoD

### **Emotion recognition through facial expression**

Importing Libraries
"""

import pandas as pd
import numpy as np
import warnings
warnings.filterwarnings("ignore")

"""Reading and pre processing data"""

data = pd.read_csv('/content/drive/My Drive/fer2013.csv')
print(data)

width, height = 48, 48

datapoints = data['pixels'].tolist()

"""getting features for training"""

X = []
for xseq in datapoints:
    xx = [int(xp) for xp in xseq.split(' ')]
    xx = np.asarray(xx).reshape(width, height)
    X.append(xx.astype('float32'))

X = np.asarray(X)
X = np.expand_dims(X, -1)

"""getting labels for training"""

y = pd.get_dummies(data['emotion']).values

"""storing them using numpy"""

np.save('fdataX', X)
np.save('flabels', y)

print("Preprocessing Done")
print("Number of Features: "+str(len(X[0])))
print("Number of Labels: "+ str(len(y[0])))
print("Number of examples in dataset:"+str(len(X)))
print("X,y stored in fdataX.npy and flabels.npy respectively")
