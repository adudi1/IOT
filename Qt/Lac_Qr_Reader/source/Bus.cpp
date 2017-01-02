#include "Bus.h"
static Bus* instance = NULL;

Bus *Bus::getInstance()
{
    if (instance == NULL)
        instance = new Bus();
    return instance;
}

Bus::~Bus()
{
    if (instance){
        delete instance;
    }
}

void Bus::onDecodedInfo(QString info)
{
    m_info = info;
}

Bus::Bus(QObject *parent) : QObject(parent)
{
    connect(this, &Bus::decodedInfo, this, &Bus::onDecodedInfo);
}
