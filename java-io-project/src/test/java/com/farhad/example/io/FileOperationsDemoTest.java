package com.farhad.example.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileOperationsDemoTest {

    @Test
    public void demonstrateFilesNotExists() {
        Path file = Paths.get("abcdef12345.123");
        assertTrue(Files.notExists(file));
    }

    @Test
    public void demonstrateFileAccessibility() throws IOException {
        Path file = Files.createFile(Paths.get("test.txt"));
        
        log.info("is readable: {}", Files.isReadable(file));
        log.info("is writable: {}", Files.isWritable(file));
        log.info("is executable: {}", Files.isExecutable(file));
        log.info("is regularFile: {}", Files.isRegularFile(file));
    }

    // When you have a file system that uses symbolic links, it is possible to have two different paths that locate the same file.
    @Test
    public void demonstrateFilesIsSameFile() throws IOException {
        Path p1 = Paths.get("home");
        Path p2 = Paths.get("./home");

        Files.createFile(Paths.get("home"));

        assertTrue(Files.isSameFile(p1, p2));
    }

    // The delete(Path) method deletes the file or throws an exception if the deletion fails. For example, if the file does 
    // not exist a NoSuchFileException is thrown.
    //
    // The deleteIfExists(Path) method also deletes the file, but if the file does not exist, no exception is thrown. 
    @Test
    public void demonstrateFilesDelete() throws IOException {

        String fileName = String.format("home%d.txt", new Random().nextInt());
        Path file = Paths.get(fileName);
        assertTrue(Files.notExists(file));

        Files.createFile(file);
        assertTrue(Files.exists(file));

        Files.delete(file);
        log.info("file {} deleted", file);
        assertTrue(Files.notExists(file));
    }

    @Test
    public void demonstrateFilesDeleteThrowsNoSuchFileException() throws IOException {

        String fileName = String.format("home%d.txt", new Random().nextInt());
        Path file = Paths.get(fileName);
        assertTrue(Files.notExists(file));

        assertThrows(
            NoSuchFileException.class,
            () -> Files.delete(file));
    }

    @Test
    public void demonstrateFileDeleteIfExists() throws IOException {
        String fileName = String.format("home%d.txt", new Random().nextInt());
        Path file = Paths.get(fileName);
        assertTrue(Files.notExists(file));

        Files.createFile(file);
        assertTrue(Files.exists(file));

        Files.deleteIfExists(file);
        log.info("file {} deleted", file);
        assertTrue(Files.notExists(file));
    }

    @Test 
    public void demonstrateFilesDeleteIfExistsNotThrowsNoSuchFileException() throws IOException {
        String fileName = String.format("home%d.txt", new Random().nextInt());
        Path file = Paths.get(fileName);
        assertTrue(Files.notExists(file));

        Files.deleteIfExists(file);
        log.info("File {} deleted or not existed", file);
    }

    // copy a file or directory by using the copy(Path, Path, CopyOption...) method. The copy fails if the target file exists, unless 
    // the REPLACE_EXISTING option is specified.
    // Directories can be copied. However, files inside the directory are not copied, so the new directory is empty even when the 
    // original directory contains files.
    // When copying a symbolic link, the target of the link is copied. If you want to copy the link itself, and not the contents of 
    // the link, specify either the NOFOLLOW_LINKS or REPLACE_EXISTING option.
    // The following StandardCopyOption and LinkOption enums are supported:
    // 
    // - REPLACE_EXISTING – Performs the copy even when the target file already exists. If the target is a symbolic link, the link itself is copied (and not the target of the link). If the target is a non-empty directory, the copy fails with the DirectoryNotEmptyException exception.
    // - COPY_ATTRIBUTES – Copies the file attributes associated with the file to the target file. The exact file attributes supported are file system and platform dependent, but last-modified-time is supported across platforms and is copied to the target file.
    // - NOFOLLOW_LINKS – Indicates that symbolic links should not be followed. If the file to be copied is a symbolic link, the link is copied (and not the target of the link).
    // 
    // the Files class also defines methods that may be used to copy between a file and a stream. The copy(InputStream, Path, CopyOptions...) 
    // method may be used to copy all bytes from an input stream to a file. The copy(Path, OutputStream) method may be used to copy all bytes 
    // from a file to an output stream.
    @Test
    public void demonstrateCopyBetweenFileAndStream() {
        // Files.copy(source, target, REPLACE_EXISTING);
    }

    // move a file or directory by using the move(Path, Path, CopyOption...) method. The move fails if the target file exists, unless 
    // the REPLACE_EXISTING option is specified.
    // Empty directories can be moved. If the directory is not empty, the move is allowed when the directory can be moved without moving 
    // the contents of that directory. On UNIX systems, moving a directory within the same partition generally consists of renaming the 
    // directory. In that situation, this method works even when the directory contains files.
    //
    // the following StandardCopyOption enums are supported:
    //
    // - REPLACE_EXISTING – Performs the move even when the target file already exists. If the target is a symbolic link, the symbolic link is replaced but what it points to is not affected.
    // - ATOMIC_MOVE – Performs the move as an atomic file operation. If the file system does not support an atomic move, an exception is thrown. With an ATOMIC_MOVE you can move a file into a directory and be guaranteed that any process watching the directory accesses a complete file.
    //


    @Test
    public void demonstrateFilesMovingFile() {
        // Files.move(source, target, REPLACE_EXISTING);
    }

    // The definition of metadata is "data about other data." With a file system, the data is contained in its files and directories, and the 
    // metadata tracks information about each of these objects: Is it a regular file, a directory, or a link? What is its size, creation date, 
    // last modified date, file owner, group owner, and access permissions?
    // 
    // A file system's metadata is typically referred to as its file attributes.
    // 
    // The Files class includes methods that can be used to obtain a single attribute of a file, or to set an attribute:
    // size/isDirectory/isRegularFile/isSymbolicLink/isHedden/getLastModified/setLastModified/getOwner/setOwner/
    // getAttribute/SetAttribute/getPosixFilePermissions/setPosixFilePermissions/readAttributes/
    //
    // related file attributes are grouped together into views. A view maps to a particular file system implementation, such as POSIX or DOS, 
    // or to a common functionality, such as file ownership.
    //
    // The supported views are as follows:
    // 
    // BasicFileAttributeView – Provides a view of basic attributes that are required to be supported by all file system implementations.
    // DosFileAttributeView – Extends the basic attribute view with the standard four bits supported on file systems that support the DOS attributes.
    // PosixFileAttributeView – Extends the basic attribute view with attributes supported on file systems that support the POSIX family of standards, such as UNIX. These attributes include file owner, group owner, and the nine related access permissions.
    // FileOwnerAttributeView – Supported by any file system implementation that supports the concept of a file owner.
    // AclFileAttributeView – Supports reading or updating a file's Access Control Lists (ACL). The NFSv4 ACL model is supported. Any ACL model, such as the Windows ACL model, that has a well-defined mapping to the NFSv4 model might also be supported.
    // UserDefinedFileAttributeView – Enables support of metadata that is user defined. This view can be mapped to any extension mechanisms that a system supports. In the Solaris OS, for example, you can use this view to store the MIME type of a file.

    @Test
    public void demonstrateFilesManagingMetadata() throws IOException { 
        Path file = Paths.get("test-file.bin");
        deleteFile(file);
        assertTrue(Files.notExists(file));

        Files.createFile(file);
        assertTrue(Files.exists(file));

        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        
        log.info("creationTime: {}", attr.creationTime());
        log.info("lastAccessTime: {}", attr.lastAccessTime());
        log.info("lastModifiedTime: {}", attr.lastModifiedTime());
        log.info("isDirectory: {}", attr.isDirectory());
        log.info("isRegularFile : {}", attr.isRegularFile());
        log.info("isOther: {}", attr.isOther());
        log.info("isSymbolicLink: {}",attr.isSymbolicLink());
        log.info("size: {}", attr.size());
        log.info("fileKey: {}", attr.fileKey());

        deleteFile(file);
        assertTrue(Files.notExists(file));
    }

    @Test
    public void demonstrateSettingFileTimestamps() throws IOException {
        Path file = Paths.get("test-file.bin"); 
        deleteFile(file) ;
        assertTrue(Files.notExists(file)); 

        Files.createFile(file);
        assertTrue(Files.exists(file));

        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        long currentTime = System.currentTimeMillis();
        FileTime fileTime = FileTime.fromMillis(currentTime);
        Files.setLastModifiedTime(file, fileTime);

        assertEquals(Files.getLastModifiedTime(file), fileTime);
    }

    // The PosixFilePermissions helper class provides several useful methods, as follows:
    // 
    // - The toString method, converts the file permissions to a string (for example, rw-r--r--).
    // - The fromString method accepts a string representing the file permissions and constructs a Set of file permissions.
    // - The asFileAttribute method accepts a Set of file permissions and constructs a file attribute that can be passed to the Path.createFile 
    //   or Path.createDirectory method.
    //
    @Test
    public void demonstratePOSIXFilePermissions() throws IOException{
        Path file = Paths.get("test-file.bin");
        deleteFile(file);
        assertTrue(Files.notExists(file));

        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-rw----");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(permissions);
        Files.createFile(file, attr);
        assertTrue(Files.exists(file));

        PosixFileAttributes pattr = Files.readAttributes(file, PosixFileAttributes.class);
        log.info("owner: {}", pattr.owner().getName());
        log.info("group: {}", pattr.group().getName());
        log.info("permissions: {}", PosixFilePermissions.toString(pattr.permissions()));

        deleteFile(file);
        assertTrue(Files.notExists(file));
    }

    @Test
    public void demonstrateSetPOSIXFilePermissions() throws IOException{
        Path file = Paths.get("test-file.bin");
        deleteFile(file);
        assertTrue(Files.notExists(file));

        Files.createFile(file);
        assertTrue(Files.exists(file));

        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-rw----");
        // FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(permissions);
        Files.setPosixFilePermissions(file, permissions);

        PosixFileAttributes pattr = Files.readAttributes(file, PosixFileAttributes.class);
        log.info("owner: {}", pattr.owner().getName());
        log.info("group: {}", pattr.group().getName());
        log.info("permissions: {}", PosixFilePermissions.toString(pattr.permissions()));

        deleteFile(file);
        assertTrue(Files.notExists(file));
    }

    @Test
    public void demonstrateAssigningAttributesFromOriginalFileToNewFile() throws IOException{
        Path originalFile = Paths.get("test-file.bin");
        Path newFile = Paths.get("new-test-file.bin");
        deleteFile(originalFile);
        assertTrue(Files.notExists(originalFile));

        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-r-----");
        FileAttribute<Set<PosixFilePermission>> originalAttr = PosixFilePermissions.asFileAttribute(permissions);
        Files.createFile(originalFile, originalAttr);
        assertTrue(Files.exists(originalFile));

        PosixFileAttributes attrs = Files.readAttributes(originalFile, PosixFileAttributes.class);
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(attrs.permissions());
        Files.createFile(newFile, attr);
        assertTrue(Files.exists(newFile));
    }

    // To translate a name into an object you can store as a file owner or a group owner, you can use the UserPrincipalLookupService service. This 
    // service looks up a name or group name as a string and returns a UserPrincipal object representing that string. 
    // You can obtain the user principal look-up service for the default file system by using the FileSystem.getUserPrincipalLookupService method.
    //
    // There is no special-purpose method in the Files class for setting a group owner. However, a safe way to do so directly is through the POSIX 
    // file attribute view.
    @Test
    public void demonstrateFilesSetOwner() throws IOException {
        Path file = Paths.get("test-file.bin");
        deleteFile(file);
        assertTrue(Files.notExists(file));

        Files.createFile(file);
        assertTrue(Files.exists(file));

        UserPrincipalLookupService service =  file.getFileSystem().getUserPrincipalLookupService();
        UserPrincipal owner = service.lookupPrincipalByName("farhad");
        GroupPrincipal group = service.lookupPrincipalByGroupName("farhad");

        Files.setOwner(file, owner);

        PosixFileAttributeView posixFileAttributeView = Files.getFileAttributeView(file, PosixFileAttributeView.class);
        posixFileAttributeView.setGroup(group);

        deleteFile(file);
        assertTrue(Files.notExists(file));
    }

    @Test
    public void demonstrateUserDefinedAttributes() throws IOException {
        Path file = Paths.get("test-file.bin");
        deleteFile(file);
        assertTrue(Files.notExists(file));

        Files.createFile(file);
        assertTrue(Files.exists(file));

        UserDefinedFileAttributeView view = Files.getFileAttributeView(file, UserDefinedFileAttributeView.class);
        view.write("mimeType", Charset.defaultCharset().encode("text/plain"));
        log.info("{}", view.list());


        Path readFile = Paths.get("test-file.bin");
        UserDefinedFileAttributeView userDefinedFileAttributeView = Files.getFileAttributeView(readFile, UserDefinedFileAttributeView.class);
        log.info("user atts: {}", userDefinedFileAttributeView.list());
      
        deleteFile(file);
        assertTrue(Files.notExists(file));
    }

    private void deleteFile(Path file) {
        try {
            Files.deleteIfExists(file);
        } catch (IOException e) {
            log.info("IOException", e);
        }
    }

}
