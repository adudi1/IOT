TEMPLATE = app

QT += qml quick widgets multimedia

CONFIG += c++11

SOURCES += main.cpp \
    viewmodels/screens/DecodedInfoScreenVM.cpp \
    viewmodels/screens/CameraScreenVM.cpp \
    viewmodels/windows/MainWindowVM.cpp \
    Bus.cpp

RESOURCES += qml.qrc

# Additional import path used to resolve QML modules in Qt Creator's code model
QML_IMPORT_PATH =

include(libs/qzxing/QZXing.pri)

# Default rules for deployment.
include(deployment.pri)

HEADERS += \
    viewmodels/screens/IScreenVM.h \
    viewmodels/screens/DecodedInfoScreenVM.h \
    viewmodels/screens/CameraScreenVM.h \
    viewmodels/windows/MainWindowVM.h \
    Bus.h
