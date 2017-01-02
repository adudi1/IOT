#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QQmlContext>
#include <QDebug>
#include <Qt>
#include "viewmodels/windows/MainWindowVM.h"
#include "viewmodels/screens/CameraScreenVM.h"
#include "viewmodels/screens/DecodedInfoScreenVM.h"


#if defined(Q_OS_IOS)
/// Reference for iOS entry point:
/// http://stackoverflow.com/questions/25353686/you-are-creating-qapplication-before-calling-uiapplicationmain-error-on-ios
extern "C" int qtmn(int argc, char **argv)
#else
int main(int argc, char *argv[])
#endif
{
    QCoreApplication::setAttribute(Qt::AA_UseHighDpiPixmaps);
    QGuiApplication app(argc, argv);
    QQmlApplicationEngine engine;

    qmlRegisterType<MainWindowVM>("MainWindowVM", 1, 0, "MainWindowVM");
    qmlRegisterType<CameraScreenVM>("CameraScreenVM", 1, 0, "CameraScreenVM");
    qmlRegisterType<DecodedInfoScreenVM>("DecodedInfoScreenVM", 1, 0, "DecodedInfoScreenVM");

    engine.load(QUrl(QStringLiteral("qrc:/ui_qml/main.qml")));
    return app.exec();
}
