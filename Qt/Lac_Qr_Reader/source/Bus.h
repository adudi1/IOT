#ifndef BUS_H
#define BUS_H

#include <QObject>

class Bus : public QObject
{
    Q_OBJECT
public:
    static Bus *getInstance();
    ~Bus();
    QString m_info;
signals:
    void decodedInfo(QString);
public slots:
    void onDecodedInfo(QString info);
private:
    explicit Bus(QObject *parent = 0);
};

#endif // BUS_H
