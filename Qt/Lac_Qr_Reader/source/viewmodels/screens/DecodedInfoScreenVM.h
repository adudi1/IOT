#ifndef DECODEDINFOSCREENVM_H
#define DECODEDINFOSCREENVM_H

#include <QObject>
#include <Bus.h>
#include <QDebug>

class DecodedInfoScreenVM : public QObject
{
    Q_OBJECT
public:
    Q_PROPERTY(QString info READ info WRITE setInfo NOTIFY infoChanged)
    explicit DecodedInfoScreenVM(QObject *parent = 0);

    QString info();
    void setInfo(QString info);
signals:
    void infoChanged();
public slots:
    void onDecoded(QString info);
private:
    QString m_info;
};

#endif // DECODEDINFOSCREENVM_H
