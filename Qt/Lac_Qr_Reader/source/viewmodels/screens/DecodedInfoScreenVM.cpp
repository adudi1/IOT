#include "DecodedInfoScreenVM.h"

DecodedInfoScreenVM::DecodedInfoScreenVM(QObject *parent) : QObject(parent)
{
    Bus *l_bus = Bus::getInstance();
    m_info = l_bus->m_info;
    QObject::connect(l_bus, SIGNAL(decodedInfo(QString)), this, SLOT(onDecoded(QString)));
}

QString DecodedInfoScreenVM::info()
{
    return m_info;
}

void DecodedInfoScreenVM::setInfo(QString info)
{
    if (m_info == info)
        return;
    m_info = info;
    infoChanged();
}

void DecodedInfoScreenVM::onDecoded(QString info)
{
    qDebug()<<info;
    setInfo(info);
}
