package Decorator;

public class DecoratorMain {

    // interface for usage of client
    interface DataSource{
        void writeData(String data);
        String readData();
    }

    // concrete data source implementation
    static class FileDataSource implements DataSource{

        @Override
        public void writeData(String data) {
            // write data to file
        }

        @Override
        public String readData() {
            // read from file and return it
            return "DATA";
        }
    }

    // This class is supposed to create interface for all the decorators,
    // its not mandatory
    static class DataSourceDecorator implements DataSource{

        private DataSource dataSourceWrapper;

        DataSourceDecorator(DataSource dataSourceWrapper) {
            this.dataSourceWrapper = dataSourceWrapper;
        }

        @Override
        public void writeData(String data) {
            this.dataSourceWrapper.writeData(data);
        }

        @Override
        public String readData() {
            return this.dataSourceWrapper.readData();
        }
    }

    // Encryption decorator which add new functionality to our read and write data
    // now it can decrypt and encrypt data and it is using same interface as normal DataSource, awesome
    static class EncryptionDecorator extends DataSourceDecorator{

        EncryptionDecorator(DataSource dataSourceWrapper) {
            super(dataSourceWrapper);
        }

        @Override
        public void writeData(String data) {
            // first we encrypt data and then we write data
            super.writeData(data);
        }

        @Override
        public String readData() {
            // first we decrypt data and then pass to wrapper readData()
            return super.readData() + ": data decrypted";
        }
    }
    
    // What is great in decorator that we cen connect those all decorates with each other
    // so in this example we can first encrypt and then compress same data
    static class CompressionDecorator extends DataSourceDecorator{

        CompressionDecorator(DataSource dataSourceWrapper) {
            super(dataSourceWrapper);
        }

        @Override
        public void writeData(String data) {
            // first we compress data and then we write data
            super.writeData(data);
        }

        @Override
        public String readData() {
            // first we uncompress data and then pass to wrapper readData()
            return super.readData() + ": data uncompressed";
        }
    }

    // client
    public static void main(String[] args) {
        DataSource dataSource = new FileDataSource();

        System.out.println(dataSource.readData());

        dataSource = new EncryptionDecorator(dataSource);

        System.out.println(dataSource.readData());

        dataSource = new CompressionDecorator(dataSource);

        System.out.println(dataSource.readData());
    }
}
