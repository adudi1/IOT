#ifndef MAIN_WINDOW_H
#define MAIN_WINDOW_H

#include <QObject>
#include <Bus.h>

class MainWindowVM : public QObject
{
    Q_OBJECT
public:
    explicit MainWindowVM(QObject *parent = 0);
    Q_PROPERTY(QString pageUrl READ pageUrl WRITE setPageUrl NOTIFY pageUrlChanged)

    QString pageUrl();
    void setPageUrl(QString url);
signals:
    void pageUrlChanged();


public slots:
    void onDecoded(QString info);

private:
    QString m_pageUrl;

};

#endif // MAIN_WINDOW_H
