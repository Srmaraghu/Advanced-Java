// Interface 1
interface Play {
    void play();
}

// Interface 2
interface Study {
    void study();
}

// Class that implements both interfaces
class MultipleInherit implements Play, Study {
    String name;

    // Constructor
    MultipleInherit(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name + " is playing sports.");
    }

    @Override
    public void study() {
        System.out.println(name + " is studying.");
    }
}
