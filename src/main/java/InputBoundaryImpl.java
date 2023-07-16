public class InputBoundaryImpl implements InputBoundary{

    private UseCase useCase;

    InputBoundaryImpl(UseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public void setName(String newName) {
        useCase.setName(NewName);
    }



}
