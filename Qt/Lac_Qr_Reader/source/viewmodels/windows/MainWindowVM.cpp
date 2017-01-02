#include "MainWindowVM.h"

MainWindowVM::MainWindowVM(QObject *parent) : QObject(parent),
    m_pageUrl("qrc:/ui_qml/screens/Camera_screen.qml")
{
    Bus *l_bus = Bus::getInstance();
    QObject::connect(l_bus,SIGNAL(decodedInfo(QString)),this,SLOT(onDecoded(QString)));
}

QString MainWindowVM::pageUrl()
{
    return m_pageUrl;
}

void MainWindowVM::setPageUrl(QString url)
{
    if (m_pageUrl == url)
        return;
    m_pageUrl = url;
    pageUrlChanged();

}

void MainWindowVM::onDecoded(QString info)
{
    setPageUrl("qrc:/ui_qml/screens/DecodedInfo_screen.qml");
}
